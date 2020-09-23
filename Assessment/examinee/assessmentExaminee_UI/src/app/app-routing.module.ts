import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InstructionComponent } from './instruction/instruction.component';
import { QuestionPaperComponent } from './question-paper/question-paper.component';

const routes: Routes = [
  { path: 'questionPaper', component: QuestionPaperComponent },
  { path: 'questionPaperinstruction/:id', component: InstructionComponent },
  { path: '', redirectTo: '/questionPaper', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
