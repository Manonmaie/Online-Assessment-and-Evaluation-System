import { Component, OnInit } from '@angular/core';
import {Course} from '../shared/course';
import {CourseService} from '../services/course.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import {setError,resetError} from '../shared/error';

@Component({
  selector: 'app-course-update',
  templateUrl: './course-update.component.html',
  styleUrls: ['./course-update.component.scss']
})
export class CourseUpdateComponent implements OnInit {
  course: Course;
  courseMasterId: number;
  constructor(private courseService: CourseService, private route: ActivatedRoute, public router: Router) { }

  ngOnInit(): void {
    this.courseMasterId = this.route.snapshot.params['id'];
    this.getCourse(this.courseMasterId);
  }

  getCourse(id: number): void{
    this.courseService.getCourse(id).subscribe((course) => this.course=course);
  }

  updateCourse(id:number,course:Course):void{
    this.courseService.updateCourse(id,course).subscribe((course)=>this.course=course);
  }

  onSubmit(){
    if(this.course.courseName==null||this.course.courseName==""){
      setError("courseName","Course Name is Required");
    }
    else{
      resetError("courseName");
      if(this.course.courseCode==null||this.course.courseCode==""){
        setError("courseCode","Course Code is Required");
      }
      else{
        this.updateCourse(this.courseMasterId,this.course);
        setTimeout(() => {
          this.router.navigate(['/courses']);
        },500);
      }
    }
  }
}
