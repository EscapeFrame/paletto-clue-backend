package hello.cluebackend.domain.user.service;

import com.oauth2jwt.domain.user.entity.UserEntity;
import com.oauth2jwt.domain.user.repository.UserRepository;
import com.oauth2jwt.web.user.dto.RegisterUserDTO;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {
    private final UserRepository userRepository;
    public RegisterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(RegisterUserDTO registerUserDTO) {
        UserEntity userEntity = new UserEntity(registerUserDTO.getStudentId(), registerUserDTO.getUsername(), registerUserDTO.getEmail(), "ROLE_USER");
        userRepository.save(userEntity);
    }
}
