package hello.cluebackend.global.exception;

import com.oauth2jwt.web.user.dto.RegisterUserDTO;

public class RedirectToRegistrationException extends RuntimeException {
    private final RegisterUserDTO registerUserDTO;
    public RedirectToRegistrationException(RegisterUserDTO registerUserDTO) {
        this.registerUserDTO = registerUserDTO;
    }
    public RegisterUserDTO getRegisterUserDTO() {
        return registerUserDTO;
    }
}
