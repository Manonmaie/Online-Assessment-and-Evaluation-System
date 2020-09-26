import { Routes } from '@angular/router';

import { ExamdriveComponent } from '../examdrive/examdrive.component';
import { CenterComponent } from '../center/center.component';
import { ExamineeComponent } from '../examinee/examinee.component';
import { CourseComponent } from '../course/course.component';
import { CenterViewComponent } from '../center-view/center-view.component';

export const routes: Routes = [
    {path: 'examdrives', component: ExamdriveComponent},
    {path: 'centers', component: CenterComponent},
    {path: 'examinees', component: ExamineeComponent},
    {path: 'courses', component: CourseComponent},
    {path: 'centerview/:id', component: CenterViewComponent},
    {path: '', redirectTo: '/examdrives', pathMatch: 'full'}
];