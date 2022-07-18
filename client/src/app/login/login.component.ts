import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  // getOrganization(){
  //   var token = Cookie.get("access_token");
  //   var payload = this.jwtHelper.decodeToken(token);
  //   this.organization = payload.organization;
  //   return this.organization;
  // }

}
