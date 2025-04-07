package lk.ijse.gdse68.userservice.service;


import lk.ijse.gdse68.userservice.dto.UserDTO;

public interface UserService {

    int saveUser(UserDTO userDTO);

    UserDTO searchUser(String userName);


}
