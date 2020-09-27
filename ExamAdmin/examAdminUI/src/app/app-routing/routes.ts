import { Routes } from '@angular/router';

import { ExamdriveComponent } from '../examdrive/examdrive.component';
import { CenterComponent } from '../center/center.component';
import { ExamineeComponent } from '../examinee/examinee.component';
import { CourseComponent } from '../course/course.component';
import { CenterViewComponent } from '../center-view/center-view.component';
import { CourseViewComponent } from '../course-view/course-view.component';
import { CenterAddComponent } from '../center-add/center-add.component';
import { CourseAddComponent } from '../course-add/course-add.component';
import { CenterUpdateComponent } from '../center-update/center-update.component';
import { CourseUpdateComponent } from '../course-update/course-update.component';

export const routes: Routes = [
    {path: 'examdrives', component: ExamdriveComponent},
    {path: 'centers', component: CenterComponent},
    {path: 'examinees', component: ExamineeComponent},
    {path: 'courses', component: CourseComponent},
    {path: 'centerview/:id', component: CenterViewComponent},
    {path: 'courseview/:id', component: CourseViewComponent},
    {path: 'centeradd', component: CenterAddComponent},
    {path: 'courseadd', component: CourseAddComponent},
    {path: 'centerupdate/:id', component: CenterUpdateComponent},
    {path: 'courseupdate/:id', component: CourseUpdateComponent},
    {path: '', redirectTo: '/examdrives', pathMatch: 'full'}
];