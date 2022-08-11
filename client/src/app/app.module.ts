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
import { FooterComponent } from './footer/footer.component';
import { NavComponent } from './nav/nav.component';
import { AccountComponent } from './account/account.component';
import {DialogDataExampleDialog, MainComponent} from './main/main.component';
import {DownloadfileService} from "./downloadfile.service";
import {ReactiveFormsModule} from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import {MatDialogModule} from "@angular/material/dialog";
import { UberComponent } from './uber/uber.component';
import { PulseComponent } from './pulse/pulse.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    // MainComponent,
    FooterComponent,
    NavComponent,
    AccountComponent,
    MainComponent,
    DialogDataExampleDialog,
    UberComponent,
    PulseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: '', component: MainComponent},
      {path: 'login', component: LoginComponent},
      // {path: 'get-cookie', component: GetCookieExampleComponent}
      {path: 'registration', component: RegistrationComponent},
      {path: 'uber', component: UberComponent},
      {path: 'pulse', component: PulseComponent},
    ]),
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatDialogModule
  ],
  providers: [CookieService, ConfigService, DownloadfileService],
  bootstrap: [AppComponent, MainComponent, DialogDataExampleDialog]
})
export class AppModule { }
