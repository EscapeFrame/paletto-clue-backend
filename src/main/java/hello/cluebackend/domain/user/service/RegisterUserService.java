package hello.cluebackend.domain.user.service;

import hello.cluebackend.domain.user.domain.UserEntity;
import hello.cluebackend.domain.user.domain.repository.UserRepository;
import hello.cluebackend.domain.user.presentation.dto.RegisterUserDTO;
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
