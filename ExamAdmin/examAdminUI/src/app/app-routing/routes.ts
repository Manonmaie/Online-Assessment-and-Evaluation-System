import { Routes } from '@angular/router';

import { ExamdriveComponent } from '../examdrive/examdrive.component';
import { CenterComponent } from '../center/center.component';
import { ExamineeComponent } from '../examinee/examinee.component';
import { CourseComponent } from '../course/course.component';
import { ExamdriveViewComponent } from '../examdrive-view/examdrive-view.component';
import { ExamdriveCenterViewComponent } from '../examdrive-center-view/examdrive-center-view.component';
import { CenterViewComponent } from '../center-view/center-view.component';
import { ExamineeViewComponent } from '../examinee-view/examinee-view.component';
import { CourseViewComponent } from '../course-view/course-view.component';
import { ExamdriveAddComponent } from '../examdrive-add/examdrive-add.component';
import { CenterAddComponent } from '../center-add/center-add.component';
import { ExamineeAddComponent } from '../examinee-add/examinee-add.component';
import { ExamineeAddBulkComponent } from '../examinee-add-bulk/examinee-add-bulk.component';
import { CourseAddComponent } from '../course-add/course-add.component';
import { ExamdriveUpdateComponent } from '../examdrive-update/examdrive-update.component';
import { ExamdriveUpdateCenterAddComponent } from '../examdrive-update-center-add/examdrive-update-center-add.component';
import { CenterUpdateComponent } from '../center-update/center-update.component';
import { ExamineeUpdateComponent } from '../examinee-update/examinee-update.component';
import { CourseUpdateComponent } from '../course-update/course-update.component';
import { ExamdriveMarksComponent } from '../examdrive-marks/examdrive-marks.component';
import { ExamdriveBatchViewComponent } from '../examdrive-batch-view/examdrive-batch-view.component';
import { LoginComponent } from '../login/login.component';

export const routes: Routes = [
    {path: 'login', component: LoginComponent},
    {path: 'examdrives', component: ExamdriveComponent},
    {path: 'centers', component: CenterComponent},
    {path: 'examinees', component: ExamineeComponent},
    {path: 'courses', component: CourseComponent},
    {path: 'examdriveview/:id', component: ExamdriveViewComponent},
    {path: 'examdriveview/:eid/centerview/:cid', component: ExamdriveCenterViewComponent},
    {path: 'centerview/:id', component: CenterViewComponent},
    {path: 'examineeview/:id', component: ExamineeViewComponent},
    {path: 'courseview/:id', component: CourseViewComponent},
    {path: 'examdriveadd', component: ExamdriveAddComponent},
    {path: 'centeradd', component: CenterAddComponent},
    {path: 'examineeadd', component: ExamineeAddComponent},
    {path: 'examineeaddbulk', component: ExamineeAddBulkComponent},
    {path: 'courseadd', component: CourseAddComponent},
    {path: 'examdriveupdate/:id', component: ExamdriveUpdateComponent},
    {path: 'examdriveupdateaddcenter/:id', component: ExamdriveUpdateCenterAddComponent},
    {path: 'centerupdate/:id', component: CenterUpdateComponent},
    {path: 'examineeupdate/:id', component: ExamineeUpdateComponent},
    {path: 'courseupdate/:id', component: CourseUpdateComponent},
    {path: 'examdrivemarksreport/:id', component: ExamdriveMarksComponent},
    {path: 'batchview/:id', component:ExamdriveBatchViewComponent},
    {path: '', redirectTo: '/login', pathMatch: 'full'}
];