import { Component, OnInit } from '@angular/core';
import {Examdrive} from '../shared/examdrive';
import {Course} from '../shared/course';
import {ExamdriveService} from '../services/examdrive.service';
import {CourseService} from '../services/course.service';
import { Params, ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-examdrive-add',
  templateUrl: './examdrive-add.component.html',
  styleUrls: ['./examdrive-add.component.scss']
})
export class ExamdriveAddComponent implements OnInit {
  examdrive = {examdriveCode: null, examdriveName: null, status: 'NOT_STARTED', course: null};
  courses: Course[];
  selectedCourse: number;

  constructor(private examdriveService: ExamdriveService, private courseService: CourseService, public route: Router) { }

  ngOnInit(): void {
    this.getCourses();
  }

  addExamdrive(examdrive: Examdrive): void{
    this.examdriveService.addExamdrive(examdrive).subscribe((examdrive)=>this.examdrive=examdrive);
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

  onSubmit(){
    this.addExamdrive(this.examdrive);
    this.route.navigate(['/examdrives']);
  }
}
