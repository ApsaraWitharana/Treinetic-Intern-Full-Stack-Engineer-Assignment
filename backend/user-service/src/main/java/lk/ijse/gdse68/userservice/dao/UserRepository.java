package lk.ijse.gdse68.userservice.dao;

import lk.ijse.gdse68.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String userName);

    boolean existsByEmail(String userName);

    int deleteByEmail (String userName);
}
