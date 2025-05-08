package hello.cluebackend.global.security.jwt;

import com.oauth2jwt.domain.jwt.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Boolean existsByRefreshToken(String refreshToken);
}