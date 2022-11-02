import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {VideoLibraryService} from "../service/video-library.service";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
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
      fullName: [],
    })
  }

  createUser() {
    this.videoLibraryService.createUser(this.formGroup.value).subscribe(res => {
      this.router.navigate(['dashboard']);
    });
  }

}
