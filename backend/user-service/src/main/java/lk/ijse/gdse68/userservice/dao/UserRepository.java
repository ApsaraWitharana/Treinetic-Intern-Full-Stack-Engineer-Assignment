package lk.ijse.gdse68.userservice.dao;

import lk.ijse.gdse68.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 #* @author : sachini apsara
 #* @date : 2024-04-07
 #* @project : task manager (Treinetic-intern-Assignment)
 #**/

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String userName);

    boolean existsByEmail(String userName);

    int deleteByEmail (String userName);
}
