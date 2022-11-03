import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class VideoLibraryService {

  BASE_URL = "http://localhost:9086/";
  VIDEO_URL = this.BASE_URL + 'api/video/'
  USER_URL = this.BASE_URL + 'api/user/'
  constructor(
    private http: HttpClient,
  ) { }

  createVideo(data: any): Observable<any> {
    let headers=new HttpHeaders().set('Authorization','Bearer '+ sessionStorage.getItem('token'));
    return this.http.post<any>(this.BASE_URL + 'video/save', data, {headers: headers});
  }

  createUser(data: any): Observable<any> {
    return this.http.post<any>(this.USER_URL + 'create', data);
  }

  getByEmail(email: any): Observable<any> {
    return this.http.get<any>(this.USER_URL + 'get-by-email/' + email);
  }

  videoViewIncrease(videoId: number): Observable<any> {
    return this.http.get<any>(this.VIDEO_URL + 'view-increase-by-video-id/' + videoId);
  }

  reactVideoById(videoId: number, userId: number, data: any): Observable<any> {
    let headers=new HttpHeaders().set('Authorization','Bearer '+ sessionStorage.getItem('token'));
    return this.http.post<any>(this.BASE_URL + 'video/react-by-video-and-user-id/' + videoId + '/' + userId, data, {headers: headers});
  }

  getVideoList (): Observable<any> {
    return this.http.get<any>(this.VIDEO_URL + 'get-list');
  }

  findOneVideo (videoId: number): Observable<any> {
    return this.http.get<any>(this.VIDEO_URL + 'find-one/' + videoId);
  }

  getListByUploaderId (uploaderId: number): Observable<any> {
    let headers=new HttpHeaders().set('Authorization','Bearer '+ sessionStorage.getItem('token'));
    return this.http.get<any>(this.BASE_URL + 'video/get-list-by-uploader-id/' + uploaderId, {headers: headers});
  }

  loginUser (data: any): Observable<any> {
    return this.http.post<any>(this.USER_URL + 'token/', data);
  }

}
