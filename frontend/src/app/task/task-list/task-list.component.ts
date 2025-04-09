import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { TaskService, Task } from '../../service/task.service';
import { CommonModule } from '@angular/common';


/**
 #    #* @author : sachini apsara
 #    #* @date : 2024-04-09
 #  #* @project : task manager (Treinetic-intern-Assignment)
 #  #**/

@Component({
  selector: 'app-dashboard',
  standalone: true,
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css'],
  imports: [CommonModule]
})
export class TaskListComponent implements OnInit {

  tasks: Task[] = [];
  constructor(
      private fb: FormBuilder,
      private router: Router,
      private taskService: TaskService
  ) {}

  ngOnInit(): void {
    this.getAllTasks();
  }

  getAllTasks(): void {
    this.taskService.getAllTasks().subscribe(
        (data) => {
          this.tasks = data;
        },
        (error) => {
          console.error('Error fetching tasks:', error);
        }
    );
  }

  deleteTask(id?: number): void {
    if (id !== undefined) {
      this.taskService.deleteTask(id).subscribe(
          (response) => {
            console.log('Task deleted:', response);
            this.getAllTasks();
          },
          (error) => {
            console.error('Error deleting task:', error);
          }
      );
    } else {
      console.warn('Invalid task id for deletion.');
    }
  }

  updateTask(id?: number, task?: Task): void {
    if (id !== undefined && task) {
      this.taskService.updateTask(id, task).subscribe(
          (response) => {
            console.log('Task updated:', response);
            this.getAllTasks();
          },
          (error) => {
            console.error('Error updating task:', error);
          }
      );
    } else {
      console.warn('Invalid task id or task data for update.');
    }
  }

  navigatingForm(): void {
    this.router.navigate(['/task_form']);
  }
}
