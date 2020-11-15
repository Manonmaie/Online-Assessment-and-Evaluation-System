import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgxPaginationModule } from 'ngx-pagination';

import { AppRoutingModule } from './app-routing/app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HttpClientModule } from "@angular/common/http";
// import { HttpModule } from "@angular/http";
import { baseURL } from "./shared/baseurl";
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

import { DriveCenterService } from "./services/drive-center.service";
import {QpItemService} from "./services/qp-item.service";
import {ResponseService} from "./services/response.service";

import { DriveCenterComponent } from './drive-center/drive-center.component';
import { QpItemComponent } from './qp-item/qp-item.component';
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
    NgxPaginationModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [
    DriveCenterService,
    QpItemService,
    ResponseService,
    {provide: 'BaseURL', useValue: baseURL}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
