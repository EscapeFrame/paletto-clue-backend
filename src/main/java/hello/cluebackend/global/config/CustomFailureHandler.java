package hello.cluebackend.global.config;

import com.oauth2jwt.common.exception.RedirectToRegistrationException;
import com.oauth2jwt.web.user.dto.RegisterUserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;

@Component
public class CustomFailureHandler implements AuthenticationFailureHandler {
//    private final HttpServletResponse response;
//
//    public CustomFailureHandler(HttpServletResponse response) {
//        this.response = response;
//    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        if (exception.getCause() instanceof RedirectToRegistrationException) {
            RedirectToRegistrationException redirectException = (RedirectToRegistrationException) exception.getCause();
            RegisterUserDTO registerUserDTO = redirectException.getRegisterUserDTO();

            String redirectUrl = "/register?username=" +
                    URLEncoder.encode(registerUserDTO.getUsername(), "UTF-8") +
                    "&email=" + URLEncoder.encode(registerUserDTO.getEmail(), "UTF-8");

            response.sendRedirect(redirectUrl);
        } else {
            response.sendRedirect("/login?error");
        }

    }
}
