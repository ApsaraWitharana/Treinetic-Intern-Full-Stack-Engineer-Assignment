import { Component, OnInit } from '@angular/core';
import { Task } from '../../model/task.model';
import {FormBuilder} from '@angular/forms';
import {Router} from '@angular/router';


@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent{
  constructor(private fb: FormBuilder , private router: Router) {}


}
