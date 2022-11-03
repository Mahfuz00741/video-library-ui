import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashboardComponent} from "./main/dashboard/dashboard.component";
import {VideoDetailsComponent} from "./main/video-details/video-details.component";
import {SignUpComponent} from "./main/sign-up/sign-up.component";
import {LoginComponent} from "./main/login/login.component";

const routes: Routes = [
  {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'sign-up', component: SignUpComponent},
  {path: 'login', component: LoginComponent},
  {path: 'video-details/:videoId', component: VideoDetailsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
