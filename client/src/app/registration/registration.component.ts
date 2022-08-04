import { Component, OnInit } from '@angular/core';
import {ConfigService} from "../config.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private configService: ConfigService, private router: Router) { }
  email: string = "";
  password: string = "";
  message: string = "";
  error: any

  ngOnInit(): void {
  }


  emailChange(e: any) {
    e.preventDefault()
    this.email = e.target.value;

  }

  passwordChange(e: any) {
    e.preventDefault()
    this.password = e.target.value;
  }

  registration(e: any){
    e.preventDefault()
    console.log("reg")
    this.configService
      .postLogin('registration', {email:this.email, password: this.password})
      .subscribe(data=>this.message = data, error => this.error = error.message)
    // this.router.navigate(['/'])
    this.email = '';
    this.password = '';
  }
}
