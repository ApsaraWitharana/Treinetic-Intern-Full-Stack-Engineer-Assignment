package lk.ijse.gdse68.taskservice.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 #* @author : sachini apsara
 #* @date : 2024-04-06
 #* @project : task manager (Treinetic-intern-Assignment)
 #**/

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskErrorResponse implements TaskResponse{

    private int errorCode;
    private String errorMassage;

}
