import { Component, OnInit } from '@angular/core';
import {Examdrive} from '../shared/examdrive';
import {Course} from '../shared/course';
import { Center } from '../shared/center';
import { Batch } from '../shared/batch';
import { Examinee } from '../shared/examinee';
import { ExamineeBatch } from '../shared/examinee-batch';
import {ExamdriveService} from '../services/examdrive.service';
import {CourseService} from '../services/course.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { BatchService } from '../services/batch.service';
import { ExamineeService } from '../services/examinee.service';
import { ExamineeBatchService } from '../services/examinee-batch.service';
import {resetError, setError} from '../shared/error';
import { newArray } from '@angular/compiler/src/util';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-examdrive-update',
  templateUrl: './examdrive-update.component.html',
  styleUrls: ['./examdrive-update.component.scss']
})
export class ExamdriveUpdateComponent implements OnInit {
  examdrive: Examdrive;
  courses: Course[];
  selectedCourse: number;
  centers: Center[] = new Array();
  isShow: boolean[];
  isUpdate: boolean[];
  batches: Batch[][];
  searchText: any;
  pageNo: number = 1;
  itemsPage: number = 25;
  examdriveId = this.route.snapshot.params['id'];
  validStatus: any[] = ['NOT_STARTED','IN_PROGRESS','COMPLETED'];
  isAddBatch: boolean = false;
  isUpload: boolean[];
  newBatch: Batch = {batchCode: null, batchStartTime: null, batchEndTime: null, qpStatus: 'PENDING', center: null, examdrive: null};
  uploadExamineeCodes: string[];
  uploadExaminees: Examinee[][];  
  uploadExamineeBatches: ExamineeBatch[][];  

  constructor(private examdriveService:ExamdriveService, private courseService: CourseService, private batchService:BatchService, private examineeService: ExamineeService, private examineeBatchService: ExamineeBatchService, private route: ActivatedRoute, public router: Router) { }

  ngOnInit(): void {
    this.getCourses();
    this.getExamdrive(this.examdriveId);
    setTimeout(() => {
      this.getCenters();
      this.selectedCourse = this.examdrive.course.courseMasterId;
      this.getCourse(this.examdrive.course.courseMasterId);
    },1000);
    this.isShow = new Array();
    this.isUpdate = new Array();
    this.batches = new Array();
    this.isUpload = new Array();
    this.uploadExamineeCodes = new Array();
    this.uploadExaminees = new Array();
    this.uploadExamineeBatches = new Array();
  }

  getExamdrive(id: number): void{
    this.examdriveService.getExamdrive(id).subscribe((examdrive) => this.examdrive=examdrive);
    this.setBatches(id);
  }

  updateExamdrive(id:number, examdrive: Examdrive): void{
    this.examdriveService.updateExamdrive(id,examdrive).subscribe((examdrive)=>this.examdrive=examdrive);
  }

  getCourses(): void{
    this.courseService.getCourses().subscribe((courses) => this.courses = courses);
  }

  getCourse(id: number): void{
    this.courseService.getCourse(id).subscribe((course) => this.examdrive.course  = course);
  }

  addCourse(){
    this.getCourse(this.selectedCourse);
  }

  getCenters(): void{
    for( var batch of this.examdrive.batchList){
      this.centers.push(batch.center);
    }
    function notEmpty<TValue>(value: TValue | null | undefined): value is TValue {
      return value !== null && value !== undefined;
    }
    this.centers = this.centers.filter(notEmpty);
    this.centers = this.centers.filter(
      (thing, i, arr) => arr.findIndex(t => t.centerId === thing.centerId) === i
    );
  }

  setBatches(id: number): void{
    this.batchService.getBatchesByExamdrive(id).subscribe((batches) => this.examdrive.batchList=batches);
  }

  showBatches(center: Center) {
    this.isUpdate[center.centerId] = false;
    this.isShow[center.centerId] = !this.isShow[center.centerId];
    if(this.batches[center.centerId]==null){
      this.getBatches(center);
    }
    setTimeout(() => {
      console.log(this.batches);
    },500);
  }

  updateBatches(center: Center) {
    this.isShow[center.centerId] = false;
    this.isUpdate[center.centerId] = true;
    if(this.batches[center.centerId]==null){
      this.getBatches(center);
    }
    setTimeout(() => {
      console.log(this.batches);
    },500);
  }

  getBatches(center: Center): void{
    this.batches[center.centerId] = this.examdrive.batchList.filter(b => b.center!=null && b.center.centerId==center.centerId);
  }

  updateDrive(){
    if(this.examdrive.examdriveName==null || this.examdrive.examdriveName==""){
      setError("examdriveName","Exam Drive name is Required");
    }
    else{
      resetError("examdriveName");
      if(this.examdrive.examdriveCode==null || this.examdrive.examdriveCode==""){
        setError("examdriveCode","Exam Drive code is Required");
      }
      else{
        resetError("examdriveCode");
        if(this.examdrive.course==null){
          setError("examdriveCourse","Course is Required");
        }
        else{
          this.updateExamdrive(this.examdriveId,this.examdrive);
          setTimeout(() => {
            this.router.navigate(['/examdrives']);
          },1000);
        }
      }
    }
  }

  onSubmit(){
    if(this.selectedCourse!=null){
      this.addCourse();
    }
    setTimeout(() => {
      this.updateDrive();
    },500);
  }

  deleteCenter(center:Center){
    if(this.batches[center.centerId]==null){
      this.getBatches(center);
    }
    setTimeout(() => {
      if(confirm("Are you sure to delete the "+center.centerName+" center from the examdrive")){
        this.centers = this.centers.filter(item => item !== center);
        this.batchService.deleteBatches(this.batches[center.centerId]).subscribe( response => {
          setTimeout(() => {
            this.batches[center.centerId]==null;
            this.ngOnInit();
          },200);
        });
      }
    },500);
  }

  updateBatch(id: number, batch: Batch, ind: number): void{
    this.isUpdate[batch.center.centerId] = false;
    this.batchService.updateBatch(id,batch).subscribe(batch => this.batches[batch.center.centerId][ind]=batch)
  }

  deleteBatch(batch: Batch): void{
    if(confirm("Are you sure to delete this batch")){
      this.batchService.deleteBatch(batch.batchId).subscribe( response => {
        this.batches[batch.center.centerId] = this.batches[batch.center.centerId].filter(item => item!=batch);
      }); 
    }
  }

  addNewBatch(): void{
    this.isAddBatch = true;
  }

  addBatch(center: Center): void{
    this.isAddBatch = false;
    this.newBatch.center = center;
    this.newBatch.examdrive = this.examdrive;
    this.batchService.addBatch(this.newBatch).subscribe( response => {
      this.batches[center.centerId].push(this.newBatch);
      setTimeout(()=>{
        window.location.reload();
      },200);
    });
    setTimeout(() => {
      this.newBatch = {batchCode: null, batchStartTime: null, batchEndTime: null, qpStatus: 'PENDING', center: null, examdrive: null};
    },200);
  }

  uploadStudents(batch: Batch): void{
    this.isUpload[batch.batchId] = true;
  }

  assignStudentsToBatch(batch: Batch): void{
    let newExamineeBatch = new ExamineeBatch();
    this.uploadExamineeBatches[batch.batchId] = new Array();
    for(let examinee of this.uploadExaminees[batch.batchId]){
      newExamineeBatch = {
        "examineeBatchId":{"examineeId":examinee.examineeId,"batchId":batch.batchId},
        "examinee":examinee,
        "batch":batch
      }
      this.uploadExamineeBatches[batch.batchId].push(newExamineeBatch);
    }
    setTimeout(()=> {
      this.examineeBatchService.addExamineeBatches(this.uploadExamineeBatches[batch.batchId]).subscribe(examineeBatchList => this.uploadExamineeBatches[batch.batchId]=examineeBatchList);
    },5000);
    this.isUpload[batch.batchId] = false;
  }

  onFileChange(ev, batch: Batch){
    let workBook = null;
    let jsonData = null;
    const reader = new FileReader();
    const file = ev.target.files[0];
    reader.onload = (event) => {
      const data = reader.result;
      workBook = XLSX.read(data, { type: 'binary' });
      jsonData = workBook.SheetNames.reduce((initial, name) => {
        const sheet = workBook.Sheets[name];
        initial["1"] = XLSX.utils.sheet_to_json(sheet);
        return initial["1"];
      }, {});
      this.uploadExamineeCodes[batch.batchId] = jsonData[0]["StudentCode"];
      for( let i=1;i<jsonData.length;i++){
        this.uploadExamineeCodes[batch.batchId] = this.uploadExamineeCodes[batch.batchId].concat(",");
        this.uploadExamineeCodes[batch.batchId] = this.uploadExamineeCodes[batch.batchId].concat(jsonData[i]["StudentCode"]);
      }
    }
    reader.readAsBinaryString(file);
    setTimeout(() => {
      this.examineeService.getExamineesByCode(this.uploadExamineeCodes[batch.batchId]).subscribe(examineeList => this.uploadExaminees[batch.batchId] = examineeList);    
    },3000);
  }
}
