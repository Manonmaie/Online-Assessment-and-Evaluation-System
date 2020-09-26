import { Component, OnInit } from '@angular/core';
import {Course} from '../shared/course';
import {CourseService} from '../services/course.service';
import {Observable, of} from 'rxjs';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.scss']
})
export class CourseComponent implements OnInit {
  courses: Course[];
  constructor(private courseService:CourseService) { }

  ngOnInit(): void {
    this.getCourses();
  }

  getCourses(): void{
    this.courseService.getCourses().subscribe((courses) => this.courses = courses);
  }

  deleteCourse(course: Course): void{
    if(confirm("Are you sure to delete the "+course.courseName+" course")){
      this.courseService.deleteCourse(course.courseMasterId).subscribe( response => {
        // alert(response.message);
        this.getCourses();
      });
    }
  }
}
