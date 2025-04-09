import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {Router} from '@angular/router';
import {TaskService,Task} from '../../service/task.service';


@Component({
  selector: 'app-dashboard',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent{
  constructor(private fb: FormBuilder , private router: Router) {}
  tasks: Task[] = [];

  constructor(private taskService: TaskService) {}

  ngOnInit() {
    this.getAllTasks();
  }

  getAllTasks() {
    this.taskService.getAllTasks().subscribe(
      (data) => {
        this.tasks = data;
      },
      (error) => {
        console.error('Error fetching tasks:', error);
      }
    );
  }

  deleteTask(id: number) {
    this.taskService.deleteTask(id).subscribe(
      (response) => {
        console.log('Task deleted:', response);
        this.getAllTasks(); // Refresh task list after deletion
      },
      (error) => {
        console.error('Error deleting task:', error);
      }
    );
  }

  updateTask(id: number, task: Task) {
    this.taskService.updateTask(id, task).subscribe(
      (response) => {
        console.log('Task updated:', response);
        this.getAllTasks(); // Refresh task list after update
      },
      (error) => {
        console.error('Error updating task:', error);
      }
    );
  }

  protected readonly navigator = navigator;
  navigatingForm() {
    this.router.navigate(['/task_form']);
  }

}
