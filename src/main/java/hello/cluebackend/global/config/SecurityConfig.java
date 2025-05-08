package hello.cluebackend.global.config;

import com.oauth2jwt.domain.jwt.service.RefreshTokenService;
import com.oauth2jwt.domain.user.service.CustomOAuth2UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomSuccessHandler customSuccessHandler;
    private final JWTUtil jwtUtil;
    private final CustomFailureHandler customFailureHandler;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService, CustomSuccessHandler customSuccessHandler, JWTUtil jwtUtil, CustomFailureHandler customFailureHandler) {
        this.customOAuth2UserService = customOAuth2UserService;
        this.customSuccessHandler = customSuccessHandler;
        this.jwtUtil = jwtUtil;
        this.customFailureHandler = customFailureHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, RefreshTokenService refreshTokenService) throws Exception {

        http
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .addLogoutHandler((request, response, authentication) -> {
                            String refreshToken = null;
                            Cookie[] cookies = request.getCookies();
                            if (cookies == null) return;
                            for (Cookie cookie : cookies) {
                                if (cookie.getName().equals("refresh_token")) {
                                    refreshToken = cookie.getValue();
                                }
                            }
                            if (refreshToken == null) {
                                throw new AuthenticationCredentialsNotFoundException("refresh_token 쿠키가 존재하지 않습니다.");
                            }
                            refreshTokenService.deleteByRefresh(refreshToken);
                            String accessToken = "";
                            response.setHeader("Authorization", "Bearer " + accessToken);

                            Cookie refreshTokenCookie = new Cookie("refresh_token", null);
                            refreshTokenCookie.setMaxAge(0);
                            refreshTokenCookie.setPath("/");
                            response.addCookie(refreshTokenCookie);
                        })
                        .deleteCookies("JSESSIONID", "refresh_token")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutSuccessHandler((request, response, authentication) -> {
                            response.setStatus(HttpServletResponse.SC_OK);
                        })

                );

        http
                .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration configuration = new CorsConfiguration();

                        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
                        configuration.setAllowedMethods(Collections.singletonList("*"));
                        configuration.setAllowCredentials(true);
                        configuration.setAllowedHeaders(Collections.singletonList("*"));
                        configuration.setMaxAge(3600L);
                        configuration.setExposedHeaders(Collections.singletonList("Authorization"));

                        return configuration;
                    }
                }));

        // csrf disable
        http
                .csrf(auth->auth.disable());

        // Form 로그인 방식 disable
        http
                .formLogin(auth->auth.disable());

        // HTTP Basic 인증 방식 disable
        http
                .httpBasic(auth->auth.disable());

        // JWTFilter 추가
        http
                // JWT 토큰 만료시 다시 로그인을 할 경우 JWT 토큰이 없어서 거절하게 되어 무한루프에 빠지게 됨
//                .addFilterBefore(new JWTFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
            .addFilterBefore(new JWTFilter(jwtUtil), OAuth2LoginAuthenticationFilter.class);
//        .addFilterAfter(new JWTFilter(jwtUtil),OAuth2LoginAuthenticationFilter.class);

        // oauth2
        http
//                .oauth2Login(Customizer.withDefaults());
            .oauth2Login(oauth2 -> oauth2
                    .userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig
                            .userService(customOAuth2UserService))
                    .successHandler(customSuccessHandler)
                    .failureHandler(customFailureHandler));

        // 경로별 인가 작업
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "refresh-token").permitAll()
                        .anyRequest().authenticated());

        // 세션 설정 : STATELESS
        http
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
