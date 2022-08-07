import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['css/aos.css', 'css/bootstrap.min.css', 'css/main.css',]
})
export class MainComponent implements OnInit {
  path: string = "./images/anthony.jpg";
  alttext: string="first image"

  constructor() { }

  ngOnInit(): void {
  }

}
