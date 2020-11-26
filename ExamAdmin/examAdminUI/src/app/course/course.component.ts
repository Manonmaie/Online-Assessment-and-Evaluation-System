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
  searchText: any;
  pageNo: number = 1;
  itemsPage: number = 25;
  constructor(private courseService:CourseService) { }

  ngOnInit(): void {
    this.getCourses();
  }

  getCourses(): void{
    this.courseService.getCourses().subscribe((courses) => {
      courses = courses.sort((obj1, obj2) => {
        if (obj1.courseCode > obj2.courseCode) {
            return 1;
        }
        if (obj1.courseCode < obj2.courseCode) {
            return -1;
        }
        return 0;
      });
      setTimeout(()=>{
        this.courses = courses;
      },500);
    });
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
