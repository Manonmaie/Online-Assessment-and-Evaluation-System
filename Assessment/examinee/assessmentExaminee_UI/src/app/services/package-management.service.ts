import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { baseURL } from "../shared/baseurl";
import { Observable, of } from "rxjs";
import { Batch } from "../shared/batch";
import { OutRpackHeader } from "../shared/outRpackHeader";
import { InEpackHeader } from "../shared/inEpackHeader";

@Injectable({
  providedIn: 'root'
})
export class PackageManagementService {

  constructor(private http: HttpClient) { }

  getAllCompletedBatchesToExport(): Observable<Batch[]>{
    return this.http.get<Batch[]>(baseURL + 'completedBatchesResponses');
  }

  // getAllSentBatchesForBatchHistory(): Observable<Batch[]>{
  //   return this.http.get<Batch[]>(baseURL + 'batchesWithSendResponses/SENT');
  // }

  getAllResponsesForBatchId(batchId: number): Observable<Response[]>{
    return this.http.get<Response[]>(baseURL + 'batch/' + batchId + '/allResponsesForBatch');
  }

  updateBatchQpStatus(batchId: number, batch: Batch): Observable<Batch>{
    return this.http.put<Batch>(baseURL + '/batch/' + batchId , batch);
  }

  getAllSentRpacksForPackHistory(): Observable<OutRpackHeader[]>{
    return this.http.get<OutRpackHeader[]>(baseURL + 'sentRpacks/SENT');
  }

  getBatchFromRpack1(batchId: number): Observable<Batch>{
    return this.http.get<Batch>(baseURL + 'batch/' + batchId + '/Rpack1');
  }

  createAndSendAllBatchesRpacks(): Observable<OutRpackHeader[]>{
    return this.http.get<OutRpackHeader[]>(baseURL + 'createRpack');
  }

  importAllEpacks(EpackKey: string): Observable<InEpackHeader[]>{
    return this.http.get<InEpackHeader[]>(baseURL + 'importFromEpack/' + EpackKey);
  }

  // updateRpackStatus(rpackHeaderId: number, outRpackHeader: OutRpackHeader): Observable<OutRpackHeader>{
  //   return this.http.put<OutRpackHeader>(baseURL + '/rpackHeader/' + rpackHeaderId , outRpackHeader);
  // }
}
