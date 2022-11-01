import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {VideoLibraryService} from "../service/video-library.service";

@Component({
  selector: 'app-video-details',
  templateUrl: './video-details.component.html',
  styleUrls: ['./video-details.component.scss']
})
export class VideoDetailsComponent implements OnInit {

  videoId: any;
  video: any;

  reactModel: any = {};
  isVideo: boolean = false;
  reactList: any[] = [];

  constructor(
    private activateRoute: ActivatedRoute,
    private videoLibraryService: VideoLibraryService,
  ) {
    this.videoId = this.activateRoute.snapshot.paramMap.get('videoId');
  }

  ngOnInit(): void {
    this.findOneVideo();
  }

  findOneVideo() {
    this.isVideo = false;
    this.reactList = [];
    this.videoLibraryService.findOneVideo(this.videoId).subscribe(res => {
      console.log(res);
      this.video = res;
      if (res.react.length > 0) {
        this.reactList = res.react;
      }
      this.isVideo = true;
    })
  }

  reactVideoById(reactType) {
    this.reactModel.reactType = reactType;
    this.videoLibraryService.reactVideoById(this.videoId, 1, this.reactModel).subscribe(res =>{
      this.findOneVideo();
    });
  }

}
