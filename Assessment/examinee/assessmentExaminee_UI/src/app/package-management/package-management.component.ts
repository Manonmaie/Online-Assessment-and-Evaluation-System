import { Component, OnInit } from '@angular/core';
import { Batch } from '../shared/batch';
import { PackageManagementService } from "../services/package-management.service";
import { ActivatedRoute } from '@angular/router';
import { OutRpackHeader } from "../shared/outRpackHeader";
import { InEpackHeader } from '../shared/inEpackHeader';

@Component({
  selector: 'app-package-management',
  templateUrl: './package-management.component.html',
  styleUrls: ['./package-management.component.scss']
})
export class PackageManagementComponent implements OnInit {

  completedBatches: Batch[];
  isBatchPresentInCompletedBatches: boolean;
  rpacksExporting: OutRpackHeader[];
  epacksImported: InEpackHeader[];
  // sentBatches: Batch[];
  sentRpacks: OutRpackHeader[];
  batchDetailsForRpack: Batch[];
  // showHistoryBoolean: boolean[];
  responsesForSelectedBatch: Response[];
  batchToBeUpdated: Batch;
  rpackToBeUpdated: OutRpackHeader;

  constructor(private packageManagementService: PackageManagementService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.packageManagementService.getAllCompletedBatchesToExport().subscribe((completedBatches) => {
      this.completedBatches = completedBatches;
      if(completedBatches != null && completedBatches.length > 0){
        this.isBatchPresentInCompletedBatches = true;
      }
      else{
        this.isBatchPresentInCompletedBatches = false;
      }
    });
    this.packageManagementService.getAllSentRpacksForPackHistory().subscribe((sentRpacks) => {
      this.sentRpacks = sentRpacks;
      // todo - get batch details for r-pack

      // this.showHistoryBoolean = [];
      // for (let i = 0; i < sentRpacks.length; i++) {
      //   this.showHistoryBoolean.push(false);
      // }
    });
    // this.packageManagementService.getAllSentBatchesForBatchHistory().subscribe((sentBatches) => this.sentBatches = sentBatches);
    // this.packageManagementService.getAllSentBatchesForBatchHistory().subscribe((sentBatches) => {
    //   this.sentBatches = sentBatches;
    //   this.showHistoryBoolean = [];
    //   for (let i = 0; i < sentBatches.length; i++) {
    //     this.showHistoryBoolean.push(false);
    //   }
    // });
  }

  exportAllRpacks(){
    // alert(" all R-Packs are exported");
    this.packageManagementService.createAndSendAllBatchesRpacks().subscribe((rpacksExporting) => {
      this.rpacksExporting = rpacksExporting;
    });
    this.isBatchPresentInCompletedBatches = false;
    for(let i = 0; i < this.completedBatches.length; i++){
      let batch = this.completedBatches[i];
      batch.qpStatus = "SENT";
      this.updateBatch(batch.batchId, batch);
    }
    window.location.reload();
  }

  // exportRPack(batch: Batch){
  //   alert("R-Pack for the selected qp is exported");
  //   this.packageManagementService.getAllResponsesForBatchId(batch.batchId).subscribe((responsesForBatch) => {
  //     // todo - fill R-Pack tables;
  //     // todo - send R-Pack;
  //   });
  //   this.isBatchPresentInCompletedBatches = false;
  //   batch.qpStatus = "SENT";
  //   this.updateBatch(batch.batchId, batch);
  //   window.location.reload();
  // }

  updateBatch(batchId: number, batch: Batch): void{
    this.packageManagementService.updateBatchQpStatus(batchId, batch).subscribe((batch) => this.batchToBeUpdated = batch);
  }
  // updateRpackHeader(rpackHeaderId: number, outRpackHeader: OutRpackHeader): void{
  //   this.packageManagementService.updateRpackStatus(rpackHeaderId, outRpackHeader).subscribe((rpackHeader) => this.rpackToBeUpdated = rpackHeader);
  // }

  importQPack(){
    // alert("Q-Pack imported");
    this.packageManagementService.importAllEpacks().subscribe((epacksImported) => {
      this.epacksImported = epacksImported;
    });
  }

  // manageViewHistoryOfSentBatch(batch: Batch, index: number): void{
  //   // this.packageManagementService.getAllResponsesForBatchId(batch.batchId).subscribe((responsesForBatch) => this.responsesForSelectedBatch = responsesForBatch);
  //   this.showHistoryBoolean[index] = !this.showHistoryBoolean[index];
  // }

}
