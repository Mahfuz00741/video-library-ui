import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {VideoLibraryService} from "../service/video-library.service";
import jwt_decode from "jwt-decode";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  formGroup: FormGroup;
  videoList: any [] = [];
  userId: any;
  isLogged: boolean = false;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private videoLibraryService: VideoLibraryService,
  ) { }

  ngOnInit(): void {
    this.intiForm();
    this.getVideoList();
    this.getUserId();
  }

  intiForm() {
    this.formGroup = this.formBuilder.group({
      videoUrl: ['', [Validators.required]],
      uploaderId: [],
      totalView: [0],
      react: []
    })
  }

  getVideoList() {
    this.videoLibraryService.getVideoList().subscribe(res => {
      this.videoList = res;
    })
  }

  createVideo() {
    this.formGroup.value.uploaderId = this.userId;
    this.videoLibraryService.createVideo(this.formGroup.value).subscribe(res => {
      this.getVideoList();
      this.formGroup.reset();
    })
  }

  btnClick(videoId: number) {
    this.router.navigate(['video-details/' + videoId]);
    this.videoViewIncrease(videoId);
  }

  videoViewIncrease(videoId) {
    this.videoLibraryService.videoViewIncrease(videoId).subscribe()
  }


  getVideo(value) {
    if (value == 'all') {
      this.getVideoList();
    } else {
      this.filterVideoList();
    }
  }

  private filterVideoList() {
    this.videoLibraryService.getListByUploaderId(this.userId).subscribe(res => {
      this.videoList = res;
    })
  }

  getUserId() {
    this.isLogged = false;
    if (sessionStorage.getItem('token') != null) {
      let token = sessionStorage.getItem('token');
      let decoded: any = jwt_decode(token);
      this.videoLibraryService.getByEmail(decoded.sub).subscribe(res => {
        this.userId = res.id;
        this.isLogged = true;
        console.log(this.userId)
      })
    }
  }

}
