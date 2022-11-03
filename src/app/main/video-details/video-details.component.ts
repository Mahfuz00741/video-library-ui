import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {VideoLibraryService} from "../service/video-library.service";
import jwt_decode from "jwt-decode";

@Component({
  selector: 'app-video-details',
  templateUrl: './video-details.component.html',
  styleUrls: ['./video-details.component.scss']
})
export class VideoDetailsComponent implements OnInit {

  videoId: any;
  video: any;
  isLike: boolean = false;
  isDislike: boolean = false;

  reactModel: any = {};
  reactList: any[] = [];
  userId: any;
  isLogged: boolean = false;

  constructor(
    private activateRoute: ActivatedRoute,
    private videoLibraryService: VideoLibraryService,
  ) {
    this.videoId = this.activateRoute.snapshot.paramMap.get('videoId');
  }

  ngOnInit(): void {
    this.findOneVideo();
    this.getUserId();
  }

  findOneVideo() {
    this.isLike = false;
    this.isDislike = false;
    this.reactList = [];
    this.videoLibraryService.findOneVideo(this.videoId).subscribe(res => {
      console.log(res);
      this.video = res;
      if (res.react.length > 0) {
        this.reactList = res.react;
        let findReactor = this.reactList.find(f => f.userId == this.userId);
        if (findReactor.isLike) {
          this.isLike = true;
        }
        if (findReactor.isDisLike) {
          this.isDislike = true;
        }
      }
    })
  }

  reactVideoById(reactType) {
    this.reactModel.reactType = reactType;
    this.videoLibraryService.reactVideoById(this.videoId, this.userId, this.reactModel).subscribe(res =>{
      this.findOneVideo();
    });
  }

  getUserId() {
    this.isLogged = false;
    if (sessionStorage.getItem('token') != null) {
      let token = sessionStorage.getItem('token');
      let decoded: any = jwt_decode(token);
      this.videoLibraryService.getByEmail(decoded.sub).subscribe(res => {
        this.userId = res.id;
        console.log(this.userId)
        this.isLogged = true;
      })
    }
  }

}
