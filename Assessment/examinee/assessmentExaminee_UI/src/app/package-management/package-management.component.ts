import { Component, OnInit } from '@angular/core';
import { Batch } from '../shared/batch';
import { PackageManagementService } from "../services/package-management.service";
import { ActivatedRoute } from '@angular/router';
import { OutRpackHeader } from "../shared/outRpackHeader";

@Component({
  selector: 'app-package-management',
  templateUrl: './package-management.component.html',
  styleUrls: ['./package-management.component.scss']
})
export class PackageManagementComponent implements OnInit {

  completedBatches: Batch[];
  sentBatches: Batch[];
  sentRpacks: OutRpackHeader[];
  showHistoryBoolean: boolean[];
  responsesForSelectedBatch: Response[];
  batchToBeUpdated: Batch;
  rpackToBeUpdated: OutRpackHeader;

  constructor(private packageManagementService: PackageManagementService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.packageManagementService.getAllCompletedBatchesToExport().subscribe((completedBatches) => this.completedBatches = completedBatches);
    this.packageManagementService.getAllSentRpacksForPackHistory().subscribe((sentRpacks) => {
      this.sentRpacks = sentRpacks;
      
      this.showHistoryBoolean = [];
      for (let i = 0; i < sentRpacks.length; i++) {
        this.showHistoryBoolean.push(false);
      }
    });
    this.packageManagementService.getAllSentBatchesForBatchHistory().subscribe((sentBatches) => this.sentBatches = sentBatches);
    // this.packageManagementService.getAllSentBatchesForBatchHistory().subscribe((sentBatches) => {
    //   this.sentBatches = sentBatches;
    //   this.showHistoryBoolean = [];
    //   for (let i = 0; i < sentBatches.length; i++) {
    //     this.showHistoryBoolean.push(false);
    //   }
    // });
  }

  exportRPack(batch: Batch){
    alert("R-Pack for the selected qp is exported");
    this.packageManagementService.getAllResponsesForBatchId(batch.batchId).subscribe((responsesForBatch) => {
      // todo - send R-Pack;
    });
    batch.qpStatus = "SENT";
    console.log(batch);
    this.updateBatch(batch.batchId, batch);
    // update R-Pack Header Status;
    window.location.reload();
  }

  updateBatch(batchId: number, batch: Batch): void{
    this.packageManagementService.updateBatchQpStatus(batchId, batch).subscribe((batch) => this.batchToBeUpdated = batch);
  }
  updateRpackHeader(rpackHeaderId: number, outRpackHeader: OutRpackHeader): void{
    this.packageManagementService.updateRpackStatus(rpackHeaderId, outRpackHeader).subscribe((rpackHeader) => this.rpackToBeUpdated = rpackHeader);
  }

  importQPack(){
    alert("Q-Pack imported");
    // todo - fill Pack tables and Actual tables
  }

  manageViewHistoryOfSentBatch(batch: Batch, index: number): void{
    // this.packageManagementService.getAllResponsesForBatchId(batch.batchId).subscribe((responsesForBatch) => this.responsesForSelectedBatch = responsesForBatch);
    this.showHistoryBoolean[index] = !this.showHistoryBoolean[index];
  }

}
