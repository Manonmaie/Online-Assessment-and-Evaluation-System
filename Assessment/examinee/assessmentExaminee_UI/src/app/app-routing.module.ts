import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InstructionComponent } from './instruction/instruction.component';
import { QuestionPaperComponent } from './question-paper/question-paper.component';
import { ExaminationComponent } from './examination/examination.component';

const routes: Routes = [
  { path: 'questionPaper/1', component: QuestionPaperComponent },
  { path: 'questionPaperinstruction/:id', component: InstructionComponent },
  { path: 'questionPaper/:examineeId/examination/:qpId/batch/:batchId', component: ExaminationComponent },
  { path: '', redirectTo: '/questionPaper/1', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


// Changes when integrated with examinee id:
//  app-routing.module.ts -> { path: 'questionPaper/1', component: QuestionPaperComponent }, to { path: 'questionPaper/:id', component: QuestionPaperComponent }
//                        -> { path: '', redirectTo: '/questionPaper/1', pathMatch: 'full' } to { path: '', redirectTo: '/questionPaper/:id', pathMatch: 'full' }
//  question-paper.component.ts -> (in onInit function and in onSelect function ) -> const examineeId = 1; to const examineeId = this.route.snapshot.params['id'];
//  instruction.component.html -> <button type="button" class="btn btn-success btn-lg btn-space" routerLink="/questionPaper/1">OK</button> to <button type="button" class="btn btn-success btn-lg btn-space" [routerLink]="['/questionPaper', examinee.examineeId]">OK</button>