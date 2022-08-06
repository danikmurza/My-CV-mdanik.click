import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css', 'aos.css', 'bootstrap.min.css', 'main.css']
})
export class MainComponent implements OnInit {
  path: string = "./images/anthony.jpg";
  alttext: string="first image"

  constructor() { }

  ngOnInit(): void {
  }

}
