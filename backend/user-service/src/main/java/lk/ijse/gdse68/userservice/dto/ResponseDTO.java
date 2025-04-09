package lk.ijse.gdse68.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 #* @author : sachini apsara
 #* @date : 2024-04-07
 #* @project : task manager (Treinetic-intern-Assignment)
 #**/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ResponseDTO {
    private int code;
    private String message;
    private Object data;


}
