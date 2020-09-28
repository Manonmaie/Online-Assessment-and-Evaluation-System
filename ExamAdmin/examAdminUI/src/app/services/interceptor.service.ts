import { Injectable } from '@angular/core';
import {
HttpInterceptor, HttpRequest,
HttpHandler, HttpEvent, HttpErrorResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
@Injectable({
providedIn: 'root'
})

export class InterceptorService implements HttpInterceptor{
    constructor() { }
    handleError(error: HttpErrorResponse){
        if(error.error instanceof ErrorEvent){
            console.log('Client Side Error: ',error);
            alert(error);
        }
        else{
            if(error.status==0){
                console.log('Server Side Error: ',error.message);
                alert(error.message);
            }
            else{
                console.log('Server Side Error: ',error.error.message);
                alert(error.error.message);
            }
        }
        return throwError(error);
    }
    intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>>{
        return next.handle(req)
        .pipe(
        catchError(this.handleError)
        )
    };
}
