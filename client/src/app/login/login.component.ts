import { Component, OnInit } from '@angular/core';
import {CookieService} from "../cookie.service";
import {ConfigService} from "../config.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private Cookie: CookieService, private http: ConfigService) { }

  ngOnInit(): void {
    this.Cookie.setCookie({name: "access_token", value: "sadfdadasdas"});
    console.log(this.Cookie.getCookie("access_token"))
    let i = this.http.getLogin('login', {email: 'mdanik@bk.ru', password: 'Danik1234'})
console.log(i)
  }

  login(){
    // this.http.getLogin('login', {email: 'mdanik@bk.ru', password: 'Danik1234'})
  }

}
