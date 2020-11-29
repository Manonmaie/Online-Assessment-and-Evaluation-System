import { Component, OnInit } from '@angular/core';
import { Course } from '../shared/course';
import {CourseService} from '../services/course.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import {resetError, setError} from '../shared/error';

@Component({
  selector: 'app-course-add',
  templateUrl: './course-add.component.html',
  styleUrls: ['./course-add.component.scss']
})
export class CourseAddComponent implements OnInit {
  course = {courseName: null,courseCode: null}
  codes: string[];
  constructor(private courseService: CourseService, public router: Router) { }

  ngOnInit(): void {
    this.getCodes();
  }

  addCourse(course: Course): void{
    this.courseService.addCourse(course).subscribe((course) => this.course=course);
  }

  getCodes(): void{
    this.courseService.getCodes().subscribe((codes)=> this.codes = codes);
  }

  onSubmit(){
    if(this.course.courseName==null || this.course.courseName==""){
      setError("courseName","Course Name is Required");
    }
    else{
      resetError("courseName");
      if(this.course.courseCode==null || this.course.courseCode==""){
        setError("courseCode","Course Code is Required");
      }
      else{
        if(this.codes.includes(this.course.courseCode)){
          setError("courseCode","This Course Code is already taken");
        }
        else{
          this.addCourse(this.course);
          setTimeout(() => {
            this.router.navigate(['/courses']);
          },500);
        }
      }
    }
  }
}
