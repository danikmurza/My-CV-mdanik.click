import { Component, OnInit } from '@angular/core';
import {CookieService} from "../cookie.service";

@Component({
  selector: 'app-get-cookie-example',
  templateUrl: './get-cookie-example.component.html',
  styleUrls: ['./get-cookie-example.component.css']
})
export class GetCookieExampleComponent implements OnInit {
  user: string | undefined;

  constructor(public cookie: CookieService) {}

  ngOnInit() {
    this.user = this.cookie.getCookie('user');
  }
}
