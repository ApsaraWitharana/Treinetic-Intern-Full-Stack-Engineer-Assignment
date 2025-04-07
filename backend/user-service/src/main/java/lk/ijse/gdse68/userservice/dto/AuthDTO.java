package lk.ijse.gdse68.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class AuthDTO implements SuperDTO{
    private String email;
    private String token;
    private String refreshToken;

}
