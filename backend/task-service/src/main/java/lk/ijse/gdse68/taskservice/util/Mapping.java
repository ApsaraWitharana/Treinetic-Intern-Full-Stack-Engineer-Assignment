package lk.ijse.gdse68.taskservice.util;

import lk.ijse.gdse68.taskservice.dto.TaskDTO;
import lk.ijse.gdse68.taskservice.entity.TaskEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 #* @author : sachini apsara
 #* @date : 2024-04-06
 #* @project : task manager (Treinetic-intern-Assignment)
 #**/

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    public TaskDTO convertToDTO(TaskEntity taskEntity){
        return new TaskDTO(
                taskEntity.getId(),// Map entity's 'id' to DTO's 'taskId'
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getStatus(),
                taskEntity.getCreatedAt()
        );
    }

    public TaskEntity convertToEntity(TaskDTO taskDTO){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(taskDTO.getTaskId()); // Map DTO's 'taskId' to entity's 'id'
        taskEntity.setTitle(taskDTO.getTitle());
        taskEntity.setDescription(taskDTO.getDescription());
        taskEntity.setStatus(taskDTO.getStatus());
        return taskEntity;
    }

}
