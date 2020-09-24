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
}
