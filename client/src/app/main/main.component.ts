import {Component, OnInit} from '@angular/core';
import {DownloadfileService} from "../downloadfile.service";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['css/aos.css', 'css/bootstrap.min.css', 'css/main.css',]
})
export class MainComponent implements OnInit {
  path: string = "./images/anthony.jpg";
  alttext: string = "first image"

  constructor(private download: DownloadfileService) {
  }

  ngOnInit(): void {
  }

  downloadFile(e: any): void {
    // e.preventDefault();
    // this.download.downloadFile()
    //   .subscribe(res=>{
    //     let fileName =
    //   })
  }
}
