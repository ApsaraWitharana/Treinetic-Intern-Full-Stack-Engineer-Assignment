import {RouterModule, Routes} from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import {RegisterComponent} from './auth/register/register.component';
import {NgModule} from '@angular/core';

export const routes: Routes = [
    { path: '', redirectTo : 'login' , pathMatch: 'full' },
    { path: 'login' , component: LoginComponent },
    { path: 'register' , component: RegisterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
