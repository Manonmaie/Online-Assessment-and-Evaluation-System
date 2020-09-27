import { Injectable } from '@angular/core';
import {Course} from '../shared/course';
import { HttpClient } from '@angular/common/http';
import {baseURL} from '../shared/baseurl';
import {Observable, of} from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient) { }

  getCourses(): Observable<Course[]>{
    return this.http.get<Course[]>(baseURL + 'courses');
  }

  deleteCourse(id: number): Observable<any>{
    return this.http.delete<any>(baseURL+'courses/'+id);
  }

  getCourse(id: number): Observable<Course>{
    return this.http.get<Course>(baseURL+'courses/'+id);
  }

  addCourse(course: Course): Observable<Course>{
    return this.http.post<Course>(baseURL + 'courses', course);
  }

  updateCourse(id: number, course: Course): Observable<Course>{
    return this.http.put<Course>(baseURL + 'courses/'+id, course);
  }
}
