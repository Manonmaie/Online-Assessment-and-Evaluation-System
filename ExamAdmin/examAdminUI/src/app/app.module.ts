import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
// import { HttpModule } from '@angular/http';
import {baseURL} from './shared/baseurl';
import { FormsModule } from '@angular/forms';

import { BatchService } from './services/batch.service';
import { CenterService } from './services/center.service';
import { CourseService } from './services/course.service';
import { ExamdriveService } from './services/examdrive.service';
import { ExamineeBatchService } from './services/examinee-batch.service';
import { ExamineeService } from './services/examinee.service';
import { ExcelServicesService } from './services/excel-services.service';
import { InterceptorService } from './services/interceptor.service';

import { AppRoutingModule } from './app-routing/app-routing.module';
import { AppComponent } from './app.component';
import { ExamdriveComponent } from './examdrive/examdrive.component';
import { HeaderComponent } from './header/header.component';
import { CenterComponent } from './center/center.component';
import { ExamineeComponent } from './examinee/examinee.component';
import { CourseComponent } from './course/course.component';
import { CenterViewComponent } from './center-view/center-view.component';
import { CourseViewComponent } from './course-view/course-view.component';
import { CenterAddComponent } from './center-add/center-add.component';
import { CourseAddComponent } from './course-add/course-add.component';
import { CenterUpdateComponent } from './center-update/center-update.component';
import { CourseUpdateComponent } from './course-update/course-update.component';
import { ExamineeViewComponent } from './examinee-view/examinee-view.component';
import { ExamineeUpdateComponent } from './examinee-update/examinee-update.component';
import { ExamineeAddComponent } from './examinee-add/examinee-add.component';
import { ExamineeAddBulkComponent } from './examinee-add-bulk/examinee-add-bulk.component';
import { ExamineeAddHeaderComponent } from './examinee-add-header/examinee-add-header.component';
import { ExamdriveAddComponent } from './examdrive-add/examdrive-add.component';
import { ExamdriveUpdateComponent } from './examdrive-update/examdrive-update.component';
import { ExamdriveViewComponent } from './examdrive-view/examdrive-view.component';
import { ExamdriveCenterViewComponent } from './examdrive-center-view/examdrive-center-view.component';

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
    CourseUpdateComponent,
    ExamineeViewComponent,
    ExamineeUpdateComponent,
    ExamineeAddComponent,
    ExamineeAddBulkComponent,
    ExamineeAddHeaderComponent,
    ExamdriveAddComponent,
    ExamdriveUpdateComponent,
    ExamdriveViewComponent,
    ExamdriveCenterViewComponent
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
    BatchService,
    CenterService,
    CourseService,
    ExamdriveService,
    ExamineeBatchService,
    ExamineeService,
    ExcelServicesService,
    InterceptorService,
    {provide: 'BaseURL', useValue: baseURL},
    {provide: HTTP_INTERCEPTORS, useClass: InterceptorService,multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
