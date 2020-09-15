import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { FlexLayoutModule } from '@angular/flex-layout';
import { QuestionPaperComponent } from './question-paper/question-paper.component';
import { HttpClientModule } from "@angular/common/http";
// import { HttpModule } from "@angular/http";
import { baseURL } from "./shared/baseurl";
import { QuestionPaperService } from "./services/question-paper.service";

@NgModule({
  declarations: [
    AppComponent,
    QuestionPaperComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    FlexLayoutModule,
    HttpClientModule
    // HttpModule
  ],
  providers: [
    QuestionPaperService,
    { provide: 'BaseURL', useValue: baseURL }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
