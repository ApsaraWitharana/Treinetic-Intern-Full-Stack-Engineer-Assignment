package lk.ijse.gdse68.taskservice.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse68.taskservice.dao.TaskDAO;
import lk.ijse.gdse68.taskservice.dto.TaskDTO;
import lk.ijse.gdse68.taskservice.entity.TaskEntity;
import lk.ijse.gdse68.taskservice.exception.DataPersistFailedException;
import lk.ijse.gdse68.taskservice.exception.TaskNotFoundException;
import lk.ijse.gdse68.taskservice.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 #* @author : sachini apsara
 #* @date : 2024-04-06
 #* @project : task manager (Treinetic-intern-Assignment)
 #**/

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final Mapping mapping;
    private final TaskDAO taskDAO;

    @Override
    public void save(TaskDTO dto) {
        TaskEntity saveTask = Optional.ofNullable(taskDAO.save(mapping.convertToEntity(dto)))
                .orElseThrow(() -> new DataPersistFailedException("Failed to save Task data!!"));
    }

    @Override
    public void delete(Long id) {
        if (taskDAO.existsById(id)) {
            taskDAO.deleteById(id);
        } else {
            throw new TaskNotFoundException("Task not found for deletion!1");
        }
    }

    @Override
    public void update(Long id, TaskDTO dto) throws ClassNotFoundException {
        TaskEntity taskEntity = taskDAO.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found for update!!"));

        taskEntity.setTitle(dto.getTitle());
        taskEntity.setDescription(dto.getDescription());
        taskEntity.setStatus(dto.getStatus());
        taskEntity.setCreatedAt(dto.getCreatedAt());
        taskDAO.save(taskEntity);
    }

    @Override
    public TaskDTO get(Long id) {
        TaskEntity taskEntity = taskDAO.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found!!"));
        return mapping.convertToDTO(taskEntity);
    }

    @Override
    public List<TaskDTO> getAll() {
        return taskDAO.findAll()
                .stream()
                .map(mapping :: convertToDTO)
                .collect(Collectors.toList());
    }
}
