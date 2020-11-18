import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {ItemFormComponent} from './item-form/item-form.component'
import {AppRoutingModule,routingComponets} from './app-routing.module'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; 
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';
import { QuestionPaperComponent } from './question-paper/question-paper.component';
import { HttpClientModule } from '@angular/common/http';
import { QuestionManagementComponent } from './question-management/question-management.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ChartsModule } from 'ng2-charts';


@NgModule({
  declarations: [
    AppComponent,
    routingComponets,
    ItemFormComponent,
    QuestionManagementComponent,
    QuestionPaperComponent,
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CKEditorModule,
    HttpClientModule,
    NgbModule,
    ReactiveFormsModule,
    ChartsModule
    ],
  providers: [],
  bootstrap: [AppComponent],
  exports: []
})
export class AppModule { }
