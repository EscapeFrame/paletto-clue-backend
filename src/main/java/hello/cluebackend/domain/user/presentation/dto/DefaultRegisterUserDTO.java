package hello.cluebackend.domain.user.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultRegisterUserDTO {
    private String email;
    private String username;
}
