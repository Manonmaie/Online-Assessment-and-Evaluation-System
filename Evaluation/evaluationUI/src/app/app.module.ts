import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DriveCenterComponent } from './drive-center/drive-center.component';
import { HttpClientModule } from "@angular/common/http";
// import { HttpModule } from "@angular/http";
import { baseURL } from "./shared/baseurl";
import { DriveCenterService } from "./services/drive-center.service";
import { QpItemComponent } from './qp-item/qp-item.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { ResponseComponent } from './response/response.component';

@NgModule({
  declarations: [
    AppComponent,
    DriveCenterComponent,
    QpItemComponent,
    ResponseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
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
