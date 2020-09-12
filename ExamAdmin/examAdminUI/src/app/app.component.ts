import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'examAdminUI';
  examDrives: string[] = ['Mid Term Examination','End Term Examination','Improvement Examination'];
}
