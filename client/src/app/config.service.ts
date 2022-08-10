import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Contact, User} from "./model/models";
import {Observable, Subscription} from "rxjs";
import {FormControl, ɵFormGroupValue, ɵTypedOrUntyped} from "@angular/forms";


@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  constructor(private http: HttpClient) {
  }

  //
  url = 'http://localhost:5000/';
  // configUrl = 'https://backend.mdanik.click/'

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
    return this.http.post<any>(this.url + path, body, this.httpOptions)

  }

  postContact(data: ɵTypedOrUntyped<{ subject: FormControl<string | null>; name: FormControl<string | null>; message: FormControl<string | null>; email: FormControl<string | null> }, ɵFormGroupValue<{ subject: FormControl<string | null>; name: FormControl<string | null>; message: FormControl<string | null>; email: FormControl<string | null> }>, any>): Observable<any> {
    const body = JSON.stringify(data)
    return this.http.post(this.url + "contact/add", body, this.httpOptions)
  }

}
