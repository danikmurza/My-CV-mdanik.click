import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from "./model/models";
import {Observable, Subscription} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  constructor(private http: HttpClient) { }

  configUrl = 'http://localhost:5000/';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      // Authorization: 'my-auth-token'
    })
  };

  getUser(): Observable<User> {
    return this.http.get<User>(this.configUrl);
  }

  getLogin(path: string, body: User): Observable<User> {
    return this.http.post<User>(this.configUrl+ path, body, this.httpOptions);
  }

  postLogin(path:string, data: User): Observable<any> {
    console.log(path)
    console.log(data)
    const headers = new HttpHeaders({'content-type': 'application/json'})
    const body = JSON.stringify(data)
    return this.http.post<any>(this.configUrl + path, body, { headers })

  }

}
