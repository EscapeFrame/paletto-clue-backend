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

    public UserDTO(String email, String role, String username, int studentId, String addition) {
        this.email = email;
        this.role = role;
        this.username = username;
        this.studentId = studentId;
        this.addition = addition;
    }

    public UserDTO() {}
}