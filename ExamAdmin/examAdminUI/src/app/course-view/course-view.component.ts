import { Component, OnInit } from '@angular/core';
import { CourseService } from '../services/course.service';
import { Params, ActivatedRoute } from '@angular/router';
import { Course } from '../shared/course';
import {Observable, of} from 'rxjs';

@Component({
  selector: 'app-course-view',
  templateUrl: './course-view.component.html',
  styleUrls: ['./course-view.component.scss']
})
export class CourseViewComponent implements OnInit {
  course: Course;
  constructor(private courseService:CourseService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const courseId = this.route.snapshot.params['id'];
    this.getCourse(courseId);
  }

  getCourse(id: number): void{
    this.courseService.getCourse(id).subscribe((course) => this.course=course);
  }
}
