import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DriveCenterComponent } from './drive-center/drive-center.component';
import { HttpClientModule } from "@angular/common/http";
// import { HttpModule } from "@angular/http";
import { baseURL } from "./shared/baseurl";
import { DriveCenterService } from "./services/drive-center.service";

@NgModule({
  declarations: [
    AppComponent,
    DriveCenterComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [
    DriveCenterService,
    {provide: 'BaseURL', useValue: baseURL}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
