import {Component} from '@angular/core';
import { Router } from '@angular/router';
import { TaskService } from '../../service/task.service';
import { Task } from '../../model/task.model';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-task-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent {
  task: Task = {
    title: '',
    description: '',
    status: '',
    createdAt : ''
  };

  constructor(private taskService: TaskService, private router: Router) {}

  onSubmit() {
    this.taskService.createTask(this.task).subscribe({
      next: (res) => {
        alert(res); // Task saved successfully!!
        this.task = { title: '', description: '', status: '',createdAt:'' };
        this.router.navigate(['/task_list']);
      },
      error: (err) => {
        alert('Error saving task: ' + err.error);
      }
    });
  }
}
