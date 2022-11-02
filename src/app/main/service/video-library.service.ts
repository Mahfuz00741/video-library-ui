import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class VideoLibraryService {

  BASE_URL = "http://localhost:9086/";
  VIDEO_URL = this.BASE_URL + 'api/video/'
  AUTH_URL = this.BASE_URL + 'auth/'
  USER_URL = this.BASE_URL + 'api/user/'
  constructor(
    private http: HttpClient,
  ) { }

  createVideo(data: any): Observable<any> {
    return this.http.post<any>(this.VIDEO_URL + 'save', data);
  }

  createUser(data: any): Observable<any> {
    return this.http.post<any>(this.USER_URL + 'create', data);
  }

  videoViewIncrease(videoId: number): Observable<any> {
    return this.http.get<any>(this.VIDEO_URL + 'view-increase-by-video-id/' + videoId);
  }

  reactVideoById(videoId: number, userId: number, data: any): Observable<any> {
    return this.http.post<any>(this.VIDEO_URL + 'react-by-video-and-user-id/' + videoId + '/' + userId, data);
  }

  getVideoList (): Observable<any> {
    // sessionStorage.setItem('token','rakib')
    // let headers=new HttpHeaders().set
    // ('Authorization','Bearer '+ sessionStorage.getItem('token'));
    return this.http.get<any>(this.VIDEO_URL + 'get-list' /*,{headers: headers}*/);
  }

  findOneVideo (videoId: number): Observable<any> {
    return this.http.get<any>(this.VIDEO_URL + 'find-one/' + videoId);
  }

  getListByUploaderId (uploaderId: number): Observable<any> {
    return this.http.get<any>(this.VIDEO_URL + 'get-list-by-uploader-id/' + uploaderId);
  }

}
