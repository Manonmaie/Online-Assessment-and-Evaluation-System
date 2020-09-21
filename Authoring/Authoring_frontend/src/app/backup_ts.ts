import { Component } from '@angular/core';
import { FormGroup, FormBuilder, FormArray } from '@angular/forms';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  selectedType: string;
  selectedCGLvl: string;
  public Editor = ClassicEditor;
  title = 'OAES-project';

  volunteerForm: FormGroup;

  constructor(private fb:FormBuilder){
  }

  ngOninit(){
    this.initializeForm();
  }

  initializeForm():void{
    this.volunteerForm = this.fb.group({
    type:'type here',
    marks:'',
    text:'',
    cg_lvl:'',
    references: this.fb.array([this.fb.control('')])
    });
  }

  onSubmit():void{
    console.log(this.volunteerForm);
  }

  get references():FormArray{
    return this.volunteerForm.get('references') as FormArray;
  }
}
