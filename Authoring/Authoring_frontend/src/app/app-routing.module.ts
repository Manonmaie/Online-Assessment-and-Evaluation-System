import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ItemFormComponent} from './item-form/item-form.component'
import { QuestionPaperComponent } from './question-paper/question-paper.component';
import { QuestionManagementComponent } from './question-management/question-management.component'
import { QpPreviewComponent } from './qp-preview/qp-preview.component'


const routes: Routes = [
  {   path: 'itemadd',   component: ItemFormComponent   },
  {   path: 'questionPaperCreate', component:QuestionPaperComponent},
  {   path:'questionManagement', component:QuestionManagementComponent},
  {   path:'qpPreview',component:QpPreviewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponets=[ItemFormComponent,QuestionPaperComponent,QuestionManagementComponent,QpPreviewComponent];