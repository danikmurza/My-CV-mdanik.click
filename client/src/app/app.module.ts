import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SetCookieExampleComponent } from './set-cookie-example/set-cookie-example.component';
import { GetCookieExampleComponent } from './get-cookie-example/get-cookie-example.component';
import {RouterModule} from "@angular/router";
import {CookieService} from "./cookie.service";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SetCookieExampleComponent,
    GetCookieExampleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot([
      {path: '', component: SetCookieExampleComponent},
      {path: 'get-cookie', component: GetCookieExampleComponent}
    ])
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
