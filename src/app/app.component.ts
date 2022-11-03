import { Component } from '@angular/core';
import jwt_decode from "jwt-decode";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'video-library-ui';


  logOut() {
    sessionStorage.setItem('token', null);
    window.location.reload();
  }



}
