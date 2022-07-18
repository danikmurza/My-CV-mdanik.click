import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {RouterModule} from "@angular/router";
import {CookieService} from "./cookie.service";
import { RegistrationComponent } from './registration/registration.component';
import {ConfigService} from "./config.service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: '', component: LoginComponent},
      // {path: 'get-cookie', component: GetCookieExampleComponent}
    ])
  ],
  providers: [CookieService, ConfigService],
  bootstrap: [AppComponent]
})
export class AppModule { }
