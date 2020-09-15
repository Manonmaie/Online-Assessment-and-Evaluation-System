import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExamdriveComponent } from './examdrive/examdrive.component';
import { HttpClientModule } from '@angular/common/http';
// import { HttpModule } from '@angular/http';
import {baseURL} from './shared/baseurl';

import {ExamdriveService} from './services/examdrive.service';

@NgModule({
  declarations: [
    AppComponent,
    ExamdriveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // HttpModule,
    HttpClientModule
  ],
  providers: [
    ExamdriveService,
    {provide: 'BaseURL', useValue: baseURL}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
