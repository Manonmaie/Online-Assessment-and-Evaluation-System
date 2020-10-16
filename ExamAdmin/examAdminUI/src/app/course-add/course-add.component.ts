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
  constructor(private courseService: CourseService, public router: Router) { }

  ngOnInit(): void {
  }

  addCourse(course: Course): void{
    this.courseService.addCourse(course).subscribe((course) => this.course=course);
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
        this.addCourse(this.course);
        setTimeout(() => {
          this.router.navigate(['/courses']);
        },500);
      }
    }
  }
}
