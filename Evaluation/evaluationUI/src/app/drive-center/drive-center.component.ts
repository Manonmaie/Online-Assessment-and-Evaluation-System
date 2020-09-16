import { Component, OnInit } from '@angular/core';
import { DriveCenterExaminee } from "../shared/DriveCenterExaminee";
import { DriveCenterService } from "../services/drive-center.service";
import { Observable, of } from "rxjs";

@Component({
  selector: 'app-drive-center',
  templateUrl: './drive-center.component.html',
  styleUrls: ['./drive-center.component.scss']
})
export class DriveCenterComponent implements OnInit {

  driveCenterExaminee : DriveCenterExaminee[];  

  constructor(private driveCenterService: DriveCenterService) { }

  ngOnInit(): void {
    this.driveCenterService.getExamDrives().subscribe((driveCenterExaminee) => this.driveCenterExaminee = driveCenterExaminee);
  }

}
