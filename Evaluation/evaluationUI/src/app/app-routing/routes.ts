import { Routes } from '@angular/router';

import { DriveCenterComponent } from '../drive-center/drive-center.component';

import { QpItemComponent } from '../qp-item/qp-item.component';


export const routes: Routes = [
    {path: 'examdrives', component: DriveCenterComponent},
    {path: 'questionPaper/:id/qpItems', component: QpItemComponent},
    {path: '', redirectTo: '/examdrives', pathMatch: 'full'}
];