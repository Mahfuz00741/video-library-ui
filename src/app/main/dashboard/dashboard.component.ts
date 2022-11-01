import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {VideoLibraryService} from "../service/video-library.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  formGroup: FormGroup;
  videoList: any [] = [];

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private videoLibraryService: VideoLibraryService,
  ) { }

  ngOnInit(): void {
    this.intiForm();
    this.getVideoList();
  }

  intiForm() {
    this.formGroup = this.formBuilder.group({
      videoUrl: ['', [Validators.required]],
      uploaderId: [1],
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
    this.videoLibraryService.createVideo(this.formGroup.value).subscribe(res => {
      this.getVideoList();
    })
  }

  btnClick(videoId: number) {
    this.router.navigate(['video-details/' + videoId]);
    this.videoViewIncrease(videoId);
  }

  videoViewIncrease(videoId) {
    this.videoLibraryService.videoViewIncrease(videoId).subscribe()
  }

}
