import { Component } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  constructor(private fb: FormBuilder , private router: Router) {}

  navigateToRegister() {
    this.router.navigate(['/register']);
  }
  login() {
      this.router.navigate(['/task_list']);
  }

}
