import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ItemFormComponent} from './item-form/item-form.component'
import { itemForm } from './question-paper/question-paper.component';
import { QuestionManagementComponent } from './question-management/question-management.component'

const routes: Routes = [
  {   path: 'itemadd',   component: ItemFormComponent   },
  {   path: 'questionPaperCreate', component:itemForm},
  {   path:'questionManagement', component:QuestionManagementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponets=[ItemFormComponent];