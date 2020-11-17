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

  completedBatches: Batch[];
  sentBatches: Batch[];
  showHistoryBoolean: boolean[];
  responsesForSelectedBatch: Response[];
  batchToBeUpdated: Batch;

  constructor(private packageManagementService: PackageManagementService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.packageManagementService.getAllCompletedBatchesToExport().subscribe((completedBatches) => this.completedBatches = completedBatches);
    this.packageManagementService.getAllSentBatchesForBatchHistory().subscribe((sentBatches) => {
      this.sentBatches = sentBatches;
      
      this.showHistoryBoolean = [];
      for (let i = 0; i < sentBatches.length; i++) {
        this.showHistoryBoolean.push(false);
      }
    });
  }

  exportRPack(batch: Batch){
    alert("R-Pack for the selected qp is exported");
    this.packageManagementService.getAllResponsesForBatchId(batch.batchId).subscribe((responsesForBatch) => {
      // todo - send R-Pack;
    });
    batch.qpStatus = "SENT";
    console.log(batch);
    this.updateBatch(batch.batchId, batch);
    window.location.reload();
  }

  updateBatch(batchId: number, batch: Batch): void{
    this.packageManagementService.updateBatchQpStatus(batchId, batch).subscribe((batch) => this.batchToBeUpdated = batch);
  }

  importQPack(){
    alert("Q-Pack imported");
  }

  manageViewHistoryOfSentBatch(batch: Batch, index: number): void{
    // this.packageManagementService.getAllResponsesForBatchId(batch.batchId).subscribe((responsesForBatch) => this.responsesForSelectedBatch = responsesForBatch);
    this.showHistoryBoolean[index] = !this.showHistoryBoolean[index];
  }

}
