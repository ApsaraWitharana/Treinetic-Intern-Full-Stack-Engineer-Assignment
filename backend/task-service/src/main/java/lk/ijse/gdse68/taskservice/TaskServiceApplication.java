package lk.ijse.gdse68.taskservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 #* @author : sachini apsara
 #* @date : 2024-04-06
 #* @project : task manager (Treinetic-intern-Assignment)
 #**/
@CrossOrigin("*")
@SpringBootApplication
public class TaskServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaskServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
