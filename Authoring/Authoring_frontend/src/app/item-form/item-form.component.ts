
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl, FormArray, FormBuilder } from '@angular/forms'
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import * as $ from 'jquery'
import { ItemServiceService } from '../service/itemService.service';
import { course } from '../shared/course';
import { Router } from '@angular/router';



@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})

export class ItemFormComponent implements OnInit  {

  countBox:number;
  subject:course[];
  constructor(private httpClient: HttpClient,private fb:FormBuilder,private itemServiceService:ItemServiceService,private router:Router) {
    this.onChange= this.onChange.bind(this);
    this.countBox=3;
    this.fb.array([])
    this.productForm = this.fb.group({
      quantities: this.fb.array([])
    });
  }


  productForm: FormGroup;

  
  quantities() : FormArray {
    return this.productForm.get("quantities") as FormArray
  }
   
  newQuantity(): FormGroup {
    return this.fb.group({
      opt: '',
      marks: '',
    })
  }
   
  addQuantity() {
    this.quantities().push(this.newQuantity());
  }
   
  removeQuantity(i:number) {
    this.quantities().removeAt(i);
  }




  ngOnInit() {
    this.itemServiceService.getCourses().subscribe((courses)=> this.subject=courses);
    $("#MCQoptionID").hide();
    $('#TFOption').hide();
  }


  


  onChange() {
    var selValue = this.selectedType;
    if(selValue=='MCQ' || selValue=='Multi_Correct_MCQ') {
      $("#MCQoptionID").show();
      $('#TFOption').hide();
    } else if(selValue=='TRUE/FALSE') {
      $('#TFOption').show();
      $("#MCQoptionID").hide();
    } else
    {
      $("#MCQoptionID").hide();
      $('#TFOption').hide();
    }
  }

  selectedType: any = "";
  selectedCGLvl: any = "";
  selectedDifLvl: any = "";
  totalMarks: Number;
  author_id: Number=1;
  selectedSub: course;
  selectedcrct:any="";
  TFmark1:any="";
  TFmark2:any="";


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
    { value: 'EASY', label: 'EASY' },
    { value: 'EASY-MEDIUM', label: 'EASY-MEDIUM' },
    { value: 'MEDIUM', label: 'MEDIUM' },
    { value: 'HARD-MEDIUM', label: 'HARD-MEDIUM' },
    { value: 'HARD', label: 'HARD' },
  ];
  types = [
    { value: '', label: 'Choose question type' },
    { value: 'MCQ', label: 'MCQ' },
    { value: 'TRUE/FALSE', label: 'TRUE/FALSE' },
    { value: 'Multi_Correct_MCQ', label: 'Multi Correct MCQ' }
  ];
  private REST_API_SERVER_MCQ = "http://localhost:8080/urest/v1/setItemMCQ";
  private REST_API_SERVER_TF = "http://localhost:8080/urest/v1/setItemTF";

  
  onSubmit(){
    var selValue = this.selectedType;
    if(selValue=='MCQ' || selValue=='Multi_Correct_MCQ')
    {
      console.log(this.selectedType, this.selectedCGLvl, this.totalMarks, this.model.editorData,this.selectedSub,this.selectedDifLvl);
      console.log(typeof this.productForm.value.quantities);
      console.log(this.productForm.value.quantities);

      this.httpClient.post(this.REST_API_SERVER_MCQ, {
      "itemText": this.model.editorData,
      "marks": this.totalMarks,
      "cgLvl": this.selectedCGLvl,
      "options": this.productForm.value.quantities,
      "diffLvl": this.selectedDifLvl,
      "authorId": this.author_id,
      "course": this.selectedSub,
      }).subscribe((data: any[])=>{
      console.log(data);
    }) 
    this.router.navigate(['/exports']);
    }

    if(selValue=='TRUE/FALSE')
    {
      console.log(this.selectedType, this.selectedCGLvl, this.totalMarks, this.model.editorData,this.selectedSub,this.selectedDifLvl);
      console.log(this.TFmark1,this.TFmark2);

      this.httpClient.post(this.REST_API_SERVER_TF, {
        "itemText": this.model.editorData,
        "marks": this.totalMarks,
        "cgLvl": this.selectedCGLvl,
        "diffLvl": this.selectedDifLvl,
        "falseMarks":this.TFmark2,
        "trueMarks":this.TFmark1,
        "authorId": this.author_id,
        "course": this.selectedSub,
        }).subscribe((data: any[])=>{
        console.log(data);
      }) 
    }
    this.router.navigate(['/exports']);
  };

}

