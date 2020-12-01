import { Component, OnInit } from '@angular/core';
import { PackageManagementService } from "../services/package-management.service";
import { ActivatedRoute } from '@angular/router';
import { OutMpackHeader } from "../shared/outMpackHeader";
import { InApackHeader } from '../shared/inApackHeader';

@Component({
  selector: 'app-package-management',
  templateUrl: './package-management.component.html',
  styleUrls: ['./package-management.component.scss']
})
export class PackageManagementComponent implements OnInit {

  mpacksExporting: OutMpackHeader[];
  apacksImported: InApackHeader[];
  sentMpacks: OutMpackHeader[];
  mpackToBeUpdated: OutMpackHeader;
  apackKey: string;
  displayErrorMessage: boolean = false;
  errorMessage: String;

  constructor(private packageManagementService: PackageManagementService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.apackKey="";
  }

  exportAllMpacks(){
    alert(" all M-Packs are exported");
    this.packageManagementService.createAndSendAllBatchesMpacks().subscribe((mpacksExporting) => {
      this.mpacksExporting = mpacksExporting;
    });
    window.location.reload();
  }


  importQPack(){
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

}
