import { Component, OnInit } from '@angular/core';
import { PackageManagementService } from "../services/package-management.service";
import { ActivatedRoute } from '@angular/router';
import { OutMpackHeader } from "../shared/outMpackHeader";
import { InApackHeader } from '../shared/inApackHeader';
import { InRpackHeader } from '../shared/inRpackHeader';

@Component({
  selector: 'app-package-management',
  templateUrl: './package-management.component.html',
  styleUrls: ['./package-management.component.scss']
})
export class PackageManagementComponent implements OnInit {

  mpacksExporting: OutMpackHeader[];
  apacksImported: InApackHeader[];
  rpacksImported: InRpackHeader[];
  sentMpacks: OutMpackHeader[];
  mpackToBeUpdated: OutMpackHeader;
  apackKey: string;
  rpackKey: string;
  mpackKey: any="";
  displayErrorMessage: boolean = false;
  errorMessage: String;

  constructor(private packageManagementService: PackageManagementService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.apackKey="";
    this.rpackKey="";
  }

  exportAllMpacks(){
    // alert(" all M-Packs are exported");
    this.packageManagementService.createAndSendAllBatchesMpacks().subscribe((statusJsonObject) => {
      this.mpackKey = statusJsonObject.key;
    });
  }


  importAPack(){
    if(this.apackKey == ""){
      this.displayErrorMessage = true;
      this.errorMessage = "Please enter Username. It is a mandatory field";
      if(this.displayErrorMessage == true){
        setTimeout(function() {
          this.displayErrorMessage = false;
          console.log("display = " + this.displayErrorMessage);
        }.bind(this), 3000);
      }
    }
    this.packageManagementService.importAllApacks(this.apackKey).subscribe((apacksImported) => {
      this.apacksImported = apacksImported;
    });
  }

  importRPack(){
    if(this.rpackKey == ""){
      this.displayErrorMessage = true;
      this.errorMessage = "Please enter Username. It is a mandatory field";
      if(this.displayErrorMessage == true){
        setTimeout(function() {
          this.displayErrorMessage = false;
          console.log("display = " + this.displayErrorMessage);
        }.bind(this), 3000);
      }
    }
    this.packageManagementService.importAllRpacks(this.rpackKey).subscribe((rpacksImported) => {
      this.rpacksImported = rpacksImported;
    });
  }

}
