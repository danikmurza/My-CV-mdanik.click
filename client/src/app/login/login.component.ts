import { Component, OnInit } from '@angular/core';
import {CookieService} from "../cookie.service";
import {ConfigService} from "../config.service";
// import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string ="";
  password: string="";
  error: any
  message: any


  constructor(private Cookie: CookieService, private http: ConfigService) { }



  ngOnInit(): void {
    this.Cookie.setCookie({name: "access_token", value: "sadfdadasdas"});
    console.log(this.Cookie.getCookie("access_token"))
    let i = this.http.getLogin('login', {email: 'mdanik@bk.ru', password: 'Danik1234'})
console.log(i)
  }



  getEmail(e: any) {
    e.preventDefault()
    this.email = e.target.value;
  }

  getPassword(e: any) {
    e.preventDefault()
    this.password = e.target.value
  }

   login(e: MouseEvent){
    e.preventDefault()
    this.http
      .postLogin('login', {email: this.email, password: this.password})
      .subscribe(data => this.message = data, error1 => this.error = error1.error)

    console.log(this.message)
     console.log(this.error)

  }


}
