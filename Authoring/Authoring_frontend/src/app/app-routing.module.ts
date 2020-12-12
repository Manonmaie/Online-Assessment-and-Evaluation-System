import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ItemFormComponent} from './item-form/item-form.component'
import { QuestionPaperComponent } from './question-paper/question-paper.component';
import { QuestionManagementComponent } from './question-management/question-management.component'
import { ExportsComponent } from './exports/exports.component'
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {   path: 'itemadd',   component: ItemFormComponent   },
  {   path: 'questionPaperCreate', component:QuestionPaperComponent},
  {   path:'questionManagement', component:QuestionManagementComponent},
  {   path:'exports', component:ExportsComponent},
  {   path: 'login', component: LoginComponent},
  {   path: '', redirectTo:'/exports',pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponets=[ItemFormComponent,QuestionPaperComponent,QuestionManagementComponent,ExportsComponent,LoginComponent];
