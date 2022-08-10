import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Contact, User} from "./model/models";
import {Observable, Subscription} from "rxjs";
import {FormControl, FormGroup, ɵFormGroupValue, ɵTypedOrUntyped} from "@angular/forms";
import {environment} from "../environments/environment";


@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  constructor(private http: HttpClient) {
  }


  url = environment.apiUrl;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      // Authorization: 'my-auth-token'
    })
  };

  getUser(): Observable<User> {
    return this.http.get<User>(this.url);
  }

  getLogin(path: string, body: User): Observable<User> {
    return this.http.post<User>(this.url + path, body, this.httpOptions);
  }

  postLogin(path: string, data: User): Observable<any> {
    console.log(path)
    console.log(data)
    const body = JSON.stringify(data)
    return this.http.post<any>(this.url+ "auth/" + path, body, this.httpOptions)

  }

  postContact(data: any): Observable<any> {
    const body = JSON.stringify(data)
    return this.http.post(this.url + "contact/add", body, this.httpOptions)
  }

}
