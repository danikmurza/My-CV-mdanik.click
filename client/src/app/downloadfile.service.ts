import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DownloadfileService {

  constructor(private httpClient: HttpClient) { }

  public downloadFile(){
   return this.httpClient.get("http://locahost:5000")
      // {observe: 'response', responseType:'blog'}
  }
}
