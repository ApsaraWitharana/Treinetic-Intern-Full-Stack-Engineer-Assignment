package lk.ijse.gdse68.userservice.service;


import lk.ijse.gdse68.userservice.dto.UserDTO;

/**
 #* @author : sachini apsara
 #* @date : 2024-04-07
 #* @project : task manager (Treinetic-intern-Assignment)
 #**/

public interface UserService {

    int saveUser(UserDTO userDTO);

    UserDTO searchUser(String userName);


}
