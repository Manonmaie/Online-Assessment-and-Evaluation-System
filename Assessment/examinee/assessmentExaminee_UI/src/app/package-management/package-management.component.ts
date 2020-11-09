import { Component, OnInit } from '@angular/core';
import { Batch } from '../shared/batch';
import { PackageManagementService } from "../services/package-management.service";
import { Params, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-package-management',
  templateUrl: './package-management.component.html',
  styleUrls: ['./package-management.component.scss']
})
export class PackageManagementComponent implements OnInit {

  batches: Batch[];

  constructor(private packageManagementService: PackageManagementService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.packageManagementService.getAllCompletedBatchesToExport().subscribe((batches) => this.batches = batches);
  }

  exportRPack(){
    alert("R Pack for the selected qp is exported");
  }

}
