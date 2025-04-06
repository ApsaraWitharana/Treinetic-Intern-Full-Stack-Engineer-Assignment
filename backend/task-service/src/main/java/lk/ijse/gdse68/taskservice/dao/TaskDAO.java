package lk.ijse.gdse68.taskservice.dao;

import lk.ijse.gdse68.taskservice.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 #* @author : sachini apsara
 #* @date : 2024-04-06
 #* @project : task manager (Treinetic-intern-Assignment)
 #**/

@Repository
public interface TaskDAO extends JpaRepository<TaskEntity,Long> {
}
