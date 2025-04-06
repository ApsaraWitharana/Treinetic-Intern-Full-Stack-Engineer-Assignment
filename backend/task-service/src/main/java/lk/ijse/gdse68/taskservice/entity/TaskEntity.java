package lk.ijse.gdse68.taskservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 #* @author : sachini apsara
 #* @date : 2024-04-06
 #* @project : task manager (Treinetic-intern-Assignment)
 #**/


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "title", nullable = false)
        private String title;
    @Column(name = "description", nullable = false)
        private String description;
    @Column(name = "status", nullable = false)
        private String status;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

}
