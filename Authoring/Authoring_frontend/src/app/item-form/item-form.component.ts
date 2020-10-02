
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import * as $ from 'jquery'


@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})

export class ItemFormComponent implements OnInit  {
  // httpClient: any;
  countBox:number;
  constructor(private httpClient: HttpClient) {
    this.onChange= this.onChange.bind(this);
    this.countBox=3;
  }

  public quantities: Array<number> = [];

  ngOnInit() {
    $("#MCQoptionsID").hide();
    $('#TFOption').hide();
    for (let i = 0; i <= 100; i++) {
      this.quantities.push(i)
    }
  }

  addInput()
  {
       var boxName="Option "+this.countBox; 
  document.getElementById('responce').innerHTML+='<div class="d-flex justify-content-between"><label class="block">'+boxName+'</label><div>Percentage of correctness(0-100): &nbsp;<input type="text" class="width-60 block" name="number" [(ngModel)]="totalMarks" /></div></div><div class=""><input type="text"  class="form-control" name="number" [(ngModel)]="totalMarks" /></div><br/>';
       this.countBox += 1;
  }


  onChange() {
    console.log(this.selectedType);
    var selValue = this.selectedType;
    if(selValue=='MCQ') {
      console.log("HIII");
      $("#MCQoptionsID").show();
      $('#TFOption').hide();
    } else if(selValue=='TRUE/FALSE') {
      $("#MCQoptionsID").hide();
      $('#TFOption').show();
    } else
    {
      $("#MCQoptionsID").hide();
      $('#TFOption').hide();
    }
  }

  selectedType: any = "";
  selectedCGLvl: any = "";
  selectedDifLvl: any = "";
  totalMarks: Number;
  selectedSub: any= "";
  selectedcrct:any="";
  option2:any="";
  option1:any="";
  crct2:any="";
  crct1:any="";


  public Editor = ClassicEditor;
  public model = {
    editorData: '<p></p>'
  };
  title = 'OAES-project';
  cgLvl = [
    { value: '',disabled:"disabled", label: 'Choose Cognitive level' },
    { value: 'REMEMBER', label: 'REMEMBER' },
    { value: 'UNDERSTAND', label: 'UNDERSTAND' },
    { value: 'APPLY', label: 'APPLY' },
    { value: 'ANALYZE', label: 'ANALYZE' },
    { value: 'EVALUATE', label: 'EVALUATE' },
    { value: 'CREATE', label: 'CREATE' },
  ];
  difLvl = [
    { value: '',disabled:"disabled", label: 'Choose Difficulty level' },
    { value: 'Easy', label: 'Easy' },
    { value: 'Medium-Easy', label: 'Medium-Easy' },
    { value: 'Medium', label: 'Medium' },
    { value: 'Medium-Hard', label: 'Medium-Hard' },
    { value: 'Hard', label: 'Hard' },
  ];
  types = [
    { value: '', label: 'Choose question type' },
    { value: 'MCQ', label: 'MCQ' },
    { value: 'TRUE/FALSE', label: 'TRUE/FALSE' },
  ];
  subject = [
    { value: '', label: 'Choose question subject' },
    { value: 'DBMS', label: 'DBMS' },
    { value: 'Data-Modelling', label: 'Data-Modelling' },
  ];
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
