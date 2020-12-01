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
  // rpacksExporting: OutRpackHeader[];
  epacksImported: InEpackHeader[];
  // sentBatches: Batch[];
  sentRpacks: OutRpackHeader[];
  batchDetailsForRpack: Batch[];
  // showHistoryBoolean: boolean[];
  responsesForSelectedBatch: Response[];
  batchToBeUpdated: Batch;
  rpackToBeUpdated: OutRpackHeader;
  batchDummy: Batch;
  epackKey: string;
  rpackKey: any="";
  displayErrorMessage: boolean = false;
  errorMessage: String;

  constructor(private packageManagementService: PackageManagementService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.epackKey="";
    this.packageManagementService.getAllCompletedBatchesToExport().subscribe((completedBatches) => {
      this.completedBatches = completedBatches;
      if(completedBatches != null && completedBatches.length > 0){
        this.isBatchPresentInCompletedBatches = true;
      }
      else{
        this.isBatchPresentInCompletedBatches = false;
      }
    });

    this.batchDetailsForRpack = [];
    this.packageManagementService.getAllSentRpacksForPackHistory().subscribe((sentRpacks) => {
      this.sentRpacks = sentRpacks;
      for(let i=0; i<sentRpacks.length; i++){
        for( let j=0; j<sentRpacks[i].rpack1List.length; j++){
          let batchId = sentRpacks[i].rpack1List[j].batch_id;
          this.packageManagementService.getBatchFromRpack1(batchId).subscribe((batch) => {
            this.batchDummy = batch;
            this.batchDetailsForRpack.push(batch);
          });
        }
      }
      // get batch details for r-pack

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
    alert(" all R-Packs are exported");
    // this.QPService.exportQPs().subscribe((j)=>this.key=j.key);
    this.packageManagementService.createAndSendAllBatchesRpacks().subscribe((statusJsonObject) => {
      // console.log("exporting");
      // alert(statusJsonObject);
      this.rpackKey = statusJsonObject.key;
      // this.rpacksExporting = rpacksExporting;
    });
    this.isBatchPresentInCompletedBatches = false;
    for(let i = 0; i < this.completedBatches.length; i++){
      let batch = this.completedBatches[i];
      batch.qpStatus = "SENT";
      this.updateBatch(batch.batchId, batch);
    }
    // window.location.reload();
  }

  // exportRPack(batch: Batch){
  //   alert("R-Pack for the selected qp is exported");
  //   this.packageManagementService.getAllResponsesForBatchId(batch.batchId).subscribe((responsesForBatch) => {
  //     // fill R-Pack tables;
  //     // send R-Pack;
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
    // alert(this.epackKey);
    if(this.epackKey == ""){
      this.displayErrorMessage = true;
      this.errorMessage = "Please enter Username. It is a mandatory field";
      if(this.displayErrorMessage == true){
        setTimeout(function() {
          this.displayErrorMessage = false;
          console.log("display = " + this.displayErrorMessage);
        }.bind(this), 3000);
      }
    }
    this.packageManagementService.importAllEpacks(this.epackKey).subscribe((epacksImported) => {
      this.epacksImported = epacksImported;
    });
  }

  // manageViewHistoryOfSentBatch(batch: Batch, index: number): void{
  //   // this.packageManagementService.getAllResponsesForBatchId(batch.batchId).subscribe((responsesForBatch) => this.responsesForSelectedBatch = responsesForBatch);
  //   this.showHistoryBoolean[index] = !this.showHistoryBoolean[index];
  // }

}
