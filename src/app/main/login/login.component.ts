import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {VideoLibraryService} from "../service/video-library.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  formGroup: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private videoLibraryService: VideoLibraryService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.intiForm();
  }

  intiForm() {
    this.formGroup = this.formBuilder.group({
      email: [],
      password: [],
    })
  }

  loginUser() {
    this.videoLibraryService.loginUser(this.formGroup.value).subscribe(res => {
      this.router.navigate(['dashboard']);
      sessionStorage.setItem('token',res.token);
      console.log(res);
    })
  }
}
