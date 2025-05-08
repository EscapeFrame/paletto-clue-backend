package hello.cluebackend.domain.user.presentation;

import com.oauth2jwt.web.user.dto.DefaultRegisterUserDTO;
import com.oauth2jwt.web.user.dto.RegisterUserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/register")
public class RegisterController {

    @GetMapping
    public DefaultRegisterUserDTO showRegistrationForm(@RequestParam("username") String username,
                                       @RequestParam("email") String email) {
        DefaultRegisterUserDTO registerUserDTO = new DefaultRegisterUserDTO();
        registerUserDTO.setUsername(username);
        registerUserDTO.setEmail(email);
        return registerUserDTO;
    }

    @PostMapping
    public String processRegistration(RegisterUserDTO registerUserDTO) {

        return "redirect:/";
    }

}
