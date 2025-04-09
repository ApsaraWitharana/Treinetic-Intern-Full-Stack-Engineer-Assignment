package lk.ijse.gdse68.taskservice.service;
import java.util.List;

/**
 #* @author : sachini apsara
 #* @date : 2024-04-06
 #* @project : task manager (Treinetic-intern-Assignment)
 #**/

public interface CRUDUtil<T>{
    void save(T dto);
    void delete(Long id);
    void update(Long id, T dto) throws ClassNotFoundException;
    T get(Long id);
    List<T> getAll();
}
