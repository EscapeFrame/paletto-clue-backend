package hello.cluebackend.domain.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int studentId;

    private String username;

    private String email;

    private String role;

    public UserEntity(int studentId, String username, String email, String role) {
        this.studentId = studentId;
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
