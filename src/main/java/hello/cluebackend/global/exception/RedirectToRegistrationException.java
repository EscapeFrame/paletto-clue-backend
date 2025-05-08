package hello.cluebackend.global.exception;

import hello.cluebackend.domain.user.presentation.dto.RegisterUserDTO;

public class RedirectToRegistrationException extends RuntimeException {
    private final RegisterUserDTO registerUserDTO;
    public RedirectToRegistrationException(RegisterUserDTO registerUserDTO) {
        this.registerUserDTO = registerUserDTO;
    }
    public RegisterUserDTO getRegisterUserDTO() {
        return registerUserDTO;
    }
}
