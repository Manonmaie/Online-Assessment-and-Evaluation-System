import { Routes } from '@angular/router';

import { DriveCenterComponent } from '../drive-center/drive-center.component';

import { QpItemComponent } from '../qp-item/qp-item.component';
import { ResponseComponent } from '../response/response.component';


export const routes: Routes = [
    {path: 'examdrives', component: DriveCenterComponent},
    {path: 'questionPaper/:id/qpItems', component: QpItemComponent},
    {path: 'examdrive/:id/responses', component: ResponseComponent},
    {path: '', redirectTo: '/examdrives', pathMatch: 'full'}
];