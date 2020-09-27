import { Component, OnInit } from '@angular/core';
import {Course} from '../shared/course';
import {CourseService} from '../services/course.service';
import { Params, ActivatedRoute, Router } from '@angular/router';

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
    this.updateCourse(this.courseMasterId,this.course);
    this.router.navigate(['/courses']);
  }
}
