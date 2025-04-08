package lk.ijse.gdse68.taskservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/healthTest")
@RequiredArgsConstructor

/**
 #* @author : sachini apsara
 #* @date : 2024-04-06
 #* @project : task manager (Treinetic-intern-Assignment)
 #**/

public class HealthTestController {
    @GetMapping
    public String healthTest(){
        return "Server Controller run Successfully!!";
    }
}
