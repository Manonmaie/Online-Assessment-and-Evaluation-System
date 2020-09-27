import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExamdriveComponent } from './examdrive/examdrive.component';
import { HeaderComponent } from './header/header.component';
import { CenterComponent } from './center/center.component';
import { ExamineeComponent } from './examinee/examinee.component';

import { HttpClientModule } from '@angular/common/http';
// import { HttpModule } from '@angular/http';
import {baseURL} from './shared/baseurl';
import { FormsModule } from '@angular/forms';

import {ExamdriveService} from './services/examdrive.service';

import {AppRoutingModule} from './app-routing/app-routing.module';
import { CourseComponent } from './course/course.component';
import { CenterViewComponent } from './center-view/center-view.component';
import { CourseViewComponent } from './course-view/course-view.component';
import { CenterAddComponent } from './center-add/center-add.component';
import { CourseAddComponent } from './course-add/course-add.component';
import { CenterUpdateComponent } from './center-update/center-update.component';
import { CourseUpdateComponent } from './course-update/course-update.component';

@NgModule({
  declarations: [
    AppComponent,
    ExamdriveComponent,
    HeaderComponent,
    CenterComponent,
    ExamineeComponent,
    CourseComponent,
    CenterViewComponent,
    CourseViewComponent,
    CenterAddComponent,
    CourseAddComponent,
    CenterUpdateComponent,
    CourseUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // HttpModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    ExamdriveService,
    {provide: 'BaseURL', useValue: baseURL}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
