import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { FlexLayoutModule } from '@angular/flex-layout';
import { QuestionPaperComponent } from './question-paper/question-paper.component';
import { HttpClientModule } from "@angular/common/http";
import { baseURL } from "./shared/baseurl";
import { InstructionComponent } from './instruction/instruction.component';
import { DatePipe } from '@angular/common'

import { QuestionPaperService } from "./services/question-paper.service";
import { InstructionService } from "./services/instruction.service";
import { ExaminationComponent } from './examination/examination.component';

@NgModule({
  declarations: [
    AppComponent,
    QuestionPaperComponent,
    InstructionComponent,
    ExaminationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    FlexLayoutModule,
    HttpClientModule
  ],
  providers: [
    QuestionPaperService,
    InstructionService,
    DatePipe,
    { provide: 'BaseURL', useValue: baseURL }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
