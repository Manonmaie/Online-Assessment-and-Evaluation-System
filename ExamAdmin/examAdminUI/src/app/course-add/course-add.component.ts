import { Component, OnInit } from '@angular/core';
import { Course } from '../shared/course';
import {CourseService} from '../services/course.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import {setError} from '../shared/error';

@Component({
  selector: 'app-course-add',
  templateUrl: './course-add.component.html',
  styleUrls: ['./course-add.component.scss']
})
export class CourseAddComponent implements OnInit {
  course = {courseName: null,courseCode: null}
  constructor(private courseService: CourseService, public route: Router) { }

  ngOnInit(): void {
  }

  addCourse(course: Course): void{
    this.courseService.addCourse(course).subscribe((course) => this.course=course);
  }

  onSubmit(){
    if(this.course.courseName==null){
      setError("courseName","Course Name is Required");
    }
    if(this.course.courseCode==null){
      setError("courseCode","Course Code is Required");
    }
    else{
      this.addCourse(this.course);
      this.route.navigate(['/courses']);
    }
  }
}
