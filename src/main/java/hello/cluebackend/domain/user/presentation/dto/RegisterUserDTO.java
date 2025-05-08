package hello.cluebackend.domain.user.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDTO {
    private String email;
    private String username;
    private int studentId;
}
