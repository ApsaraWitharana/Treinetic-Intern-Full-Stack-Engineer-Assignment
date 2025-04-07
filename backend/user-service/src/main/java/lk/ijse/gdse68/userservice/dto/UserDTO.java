package lk.ijse.gdse68.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 #* @author : sachini apsara
 #* @date : 2024-04-07
 #* @project : task manager (Treinetic-intern-Assignment)
 #**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements SuperDTO{
    private String email;
    private String password;
}
