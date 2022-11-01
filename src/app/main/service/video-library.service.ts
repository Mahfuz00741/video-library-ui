import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class VideoLibraryService {

  BASE_URL = "http://localhost:9086/api/";
  VIDEO_URL = this.BASE_URL + 'video/'
  constructor(
    private http: HttpClient,
  ) { }

  createVideo(data: any): Observable<any> {
    return this.http.post<any>(this.VIDEO_URL + 'save', data);
  }

  videoViewIncrease(videoId: number): Observable<any> {
    return this.http.get<any>(this.VIDEO_URL + 'view-increase-by-video-id/' + videoId);
  }

  reactVideoById(videoId: number, userId: number, data: any): Observable<any> {
    return this.http.post<any>(this.VIDEO_URL + 'react-by-video-and-user-id/' + videoId + '/' + userId, data);
  }

  getVideoList (): Observable<any> {
    return this.http.get<any>(this.VIDEO_URL + 'get-list');
  }

  findOneVideo (videoId: number): Observable<any> {
    return this.http.get<any>(this.VIDEO_URL + 'find-one/' + videoId);
  }

}
