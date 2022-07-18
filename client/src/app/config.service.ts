import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from "./interface/User";


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

  getUser() {
    return this.http.get<User>(this.configUrl);
  }

  getLogin(path: string, body: User) {
    return this.http.post<User>(this.configUrl+ path, body, this.httpOptions);
  }

}
