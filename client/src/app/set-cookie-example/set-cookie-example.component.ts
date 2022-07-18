import { Component, OnInit } from '@angular/core';
import {CookieService} from "../cookie.service";

@Component({
  selector: 'app-set-cookie-example',
  templateUrl: './set-cookie-example.component.html',
  styleUrls: ['./set-cookie-example.component.css']
})
export class SetCookieExampleComponent implements OnInit {
  constructor(public cookie: CookieService) {}

  ngOnInit() {
    this.cookie.setCookie({
      name: 'user',
      value: 'Readerstack',
      session: true,
    });
  }
}
