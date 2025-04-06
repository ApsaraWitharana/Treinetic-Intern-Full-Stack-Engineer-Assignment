package lk.ijse.gdse68.taskservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/**
 #* @author : sachini apsara
 #* @date : 2024-04-06
 #* @project : task manager (Treinetic-intern-Assignment)
 #**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Long taskId;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createdAt;
}
