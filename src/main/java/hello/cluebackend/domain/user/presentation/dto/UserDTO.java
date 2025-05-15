package hello.cluebackend.domain.user.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String email;
    private String role;
    private String username;
    private int studentId;
    private String addition;
}