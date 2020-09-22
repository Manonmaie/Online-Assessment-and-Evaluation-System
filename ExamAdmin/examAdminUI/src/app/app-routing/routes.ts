import { Routes } from '@angular/router';

import { ExamdriveComponent } from '../examdrive/examdrive.component';
import { CenterComponent } from '../center/center.component';
import { ExamineeComponent } from '../examinee/examinee.component';

export const routes: Routes = [
    {path: 'examdrives', component: ExamdriveComponent},
    {path: 'centers', component: CenterComponent},
    {path: 'examinees', component: ExamineeComponent},
    {path: '', redirectTo: '/examdrives', pathMatch: 'full'}
];