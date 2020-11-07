import { FormGroup, FormControl, FormArray, FormBuilder } from '@angular/forms'
import { ItemServiceService } from '../service/itemService.service';
import { ItemFilterServiceService } from '../service/item-filter-service.service';
import { Router } from '@angular/router';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { HttpParams } from '@angular/common/http';
import { QP } from '../shared/QP'
import {QPServiceService} from '../service/qpservice.service'
import { Component, OnInit } from '@angular/core';


  
@Component({
  selector: 'my-app',
  templateUrl: './question-paper.component.html',
  styleUrls: [ './question-paper.component.css' ]
})
export class QuestionPaperComponent implements OnInit {

  selectedType: any = "";
  totalMarks: Number;
  instructions: string;
  selectedSub: any= "";
  ngType: any=true;
  testDuration: Number;
  endMark: Number=100;
  startMark: Number=0;
  subject = [
    { value: '', label: 'Choose question subject' },
    { value: 'DBMS', label: 'DBMS' },
    { value: 'Data-Modelling', label: 'Data-Modelling' },
  ];
  types = [
    { value: 'MCQ', label: 'MCQ', checked: false },
    { value: 'TF', label: 'TF', checked: false },
    { value: 'Multi_Correct_MCQ', label: 'Multi Correct MCQ', checked: false }
  ];
  form: FormGroup;
  difLvl = [
    { value: 'Easy', label: 'Easy', checked: false},
    { value: 'Medium-Easy', label: 'Medium-Easy', checked: false},
    { value: 'Medium', label: 'Medium', checked: false },
    { value: 'Medium-Hard', label: 'Medium-Hard', checked: false },
    { value: 'Hard', label: 'Hard', checked: false },
  ];

  cgLvl = [
    { value: 'REMEMBER', label: 'REMEMBER', checked: false },
    { value: 'UNDERSTAND', label: 'UNDERSTAND', checked: false },
    { value: 'APPLY', label: 'APPLY', checked: false },
    { value: 'ANALYZE', label: 'ANALYZE', checked: false },
    { value: 'EVALUATE', label: 'EVALUATE', checked: false },
    { value: 'CREATE', label: 'CREATE', checked: false },
  ];


  ngOnInit() {
  }
  get ordersFormArray() {
    return this.form.controls.orders as FormArray;
  }

  page = 1;
  myQPSet: Set<number> = new Set<number>();
  pageSize = 10;
  collectionSize=3;
  author_id: Number=1;
  items=[];
  // qp:QP[];
  public Editor = ClassicEditor;
  public model = {
    editorData: '<p></p>'
  };


  constructor(private ItemService: ItemServiceService,private ItemFilterService:ItemFilterServiceService,private router:Router,private QPService :QPServiceService) {
    this.getitem(this.author_id);
    this.refreshItems();
    this.onFilterChange = this.onFilterChange.bind(this);
  }

  // params = params.set('name', name);

    setFilterValue(params:HttpParams,): void{
    
  }

  editQPList(itemId: number){
    // for (let currentNumber of this.myQPSet) {
    //   console.log(currentNumber);     //1 2 3 4 5 6
    //   }
    // console.log(this.myQPSet.size);
      if(this.myQPSet.has(itemId))
      {
        this.myQPSet.delete(itemId);  
        return false;
      }
      else
      {
        this.myQPSet.add(itemId);  
        return true;
      }
  }

  onFilterChange() {
    console.log(this);
    var params = new HttpParams();
    // difLvl
    var difLvlArray=[]; 
    this.difLvl.forEach(function (value) {
      if(value.checked==true)
        difLvlArray.push(value.label);
    }); 
    if(difLvlArray.length==0)
    {
      this.difLvl.forEach(function (value) {
          difLvlArray.push(value.label);
      }); 
    }
    params = params.set('difLvl',difLvlArray.join(','));


    // cgLvlvar difLvlArray=[]; 
    var cgLvlArray=[]; 
    this.cgLvl.forEach(function (value) {
      if(value.checked==true)
        cgLvlArray.push(value.label);
    });
    if(cgLvlArray.length==0)
    {
      this.cgLvl.forEach(function (value) {
          cgLvlArray.push(value.label);
      });
    } 
    params = params.append('cgLvl', cgLvlArray.join(','));


    // types
    var typesArray=[]; 
    this.types.forEach(function (value) {
      if(value.checked==true)
      typesArray.push(value.label);
    });
    if(typesArray.length==0)
    {
      this.types.forEach(function (value) {
        typesArray.push(value.label);
      });
    }  
    params = params.set('types', typesArray.join(','));


    // subject
    params = params.set('subject',this.selectedType);

    
    // start marks;
    if(this.startMark!=null)
    params = params.set('startMark',JSON.stringify(this.startMark));
    else
    params = params.set('startMark',JSON.stringify("0"));


    // end marks;
    if(this.endMark!=null)
    params = params.set('endMark',JSON.stringify(this.endMark));
    else
    params = params.set('endMark',JSON.stringify("0"));
    
    this.getItemFilter(params);
  }

  ngOnChanges() {
    console.log(this.types);
  }

  stringToHTML(id, str) {
    var parser = new DOMParser();
    var doc = parser.parseFromString(str, 'text/html');
    console.log(str);
    document.getElementById(id).innerHTML = str;
  };

  refreshItems() {
    this.items
    .map((item, i) => ({id: i + 1, ...item}))
      .slice((this.page - 1) * this.pageSize, (this.page - 1) * this.pageSize + this.pageSize);
  }


  editItem(){
    this.router.navigate(['/itemadd']);
  }

  getitem(author_id: Number): void{
    this.ItemService.getitem(author_id).subscribe((items)=> this.items=items);
    console.log(this.items);
  }


  // retrieval of questions based on filters 
  getItemFilter(parmas): void{
    console.log(JSON.stringify(parmas));
    this.ItemFilterService.getitemFilter(parmas).subscribe((items)=> this.items=items);
    console.log(this.items);
  }

  setQP(): void{
    // this.ItemFilterService.setQP().subscribe((items)=> this.items=items);
    console.log(this.selectedSub);
    this.QPService.setQP(this.selectedSub,this.totalMarks,this.testDuration,this.instructions,Array.from(this.myQPSet.values()));
  }
}