import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-package-management',
  templateUrl: './package-management.component.html',
  styleUrls: ['./package-management.component.scss']
})
export class PackageManagementComponent implements OnInit {

  apackKey: string;
  rpackKey: string;
  displayErrorMessage: boolean = false;
  errorMessage: String;

  constructor() { }


  ngOnInit(): void {
  }

}
