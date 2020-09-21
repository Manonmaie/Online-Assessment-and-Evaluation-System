import { Component } from '@angular/core';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private httpClient: HttpClient) { }
  selectedType: any = "";
  selectedCGLvl: any = "";
  totalMarks: Number;
  public Editor = ClassicEditor;
  public model = {
    editorData: '<p></p>'
  };
  title = 'OAES-project';
  // cgLvl = [
  //   { value: '', label: 'Age group' },
  //   { value: 'REMEMBER', label: '2 to 3 years' },
  //   { value: '3-4', label: '3 to 4 years' },
  //   { value: '4-6', label: '4 to 6 years' },
  //   { value: '6-8', label: '6 to 8 years' },
  //   { value: '8-12', label: '8 to 12 years' },
  // ];
  cgLvl = [
    { value: '', label: 'Choose Cognitive level' },
    { value: 'REMEMBER', label: 'REMEMBER' },
    { value: 'UNDERSTAND', label: 'UNDERSTAND' },
    { value: 'APPLY', label: 'APPLY' },
    { value: 'ANALYZE', label: 'ANALYZE' },
    { value: 'EVALUATE', label: 'EVALUATE' },
    { value: 'CREATE', label: 'CREATE' },
  ];
  types = [
    { value: '', label: 'Choose question type' },
    { value: 'MCQ', label: 'MCQ' },
    { value: 'TRUE/FALSE', label: 'TRUE/FALSE' },
  ]
  private REST_API_SERVER = "http://localhost:8080/urest/v1/setItem";
  onSubmit(){
    console.log(this.selectedType, this.selectedCGLvl, this.totalMarks, this.model.editorData);
    this.httpClient.post(this.REST_API_SERVER, {
      "question": this.model.editorData,
      "marks": this.totalMarks,
      "cg_lvl": this.selectedCGLvl,
    }).subscribe((data: any[])=>{
      console.log(data);
    }) 
  };
}
