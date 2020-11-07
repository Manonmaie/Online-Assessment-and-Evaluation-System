import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { FlexLayoutModule } from '@angular/flex-layout';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from '@angular/forms';
import { baseURL } from "./shared/baseurl";
import { DatePipe } from '@angular/common'
import { QuestionPaperService } from "./services/question-paper.service";
import { InstructionService } from "./services/instruction.service";
import { ExaminationService } from "./services/examination.service";
import { LoginService } from "./services/login.service";
import { PackageManagementService } from "./services/package-management.service";
import { AppComponent } from './app.component';
import { QuestionPaperComponent } from './question-paper/question-paper.component';
import { InstructionComponent } from './instruction/instruction.component';
import { ExaminationComponent } from './examination/examination.component';
import { HeaderComponent } from './header/header.component';
import { PackageManagementComponent } from './package-management/package-management.component';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    QuestionPaperComponent,
    InstructionComponent,
    ExaminationComponent,
    HeaderComponent,
    PackageManagementComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    FlexLayoutModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    QuestionPaperService,
    InstructionService,
    ExaminationService,
    LoginService,
    PackageManagementService,
    DatePipe,
    { provide: 'BaseURL', useValue: baseURL }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
