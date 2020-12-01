// asExamineeBatch":{"":{"":2,"batchId":1},"examinee":{"examineeId":2,"examineeCode":"S2","examineeName":"XYZ","examineePassword":"xyz","examineeBranch":null,"examineeEmail":null,"examineeCollege":null},"batch":{"batchId":1,"batchCode":"Mrng1","batchStartTime":"2020-09-27T14:00:00","batchEndTime":"2020-09-27T23:00:00","qpStatus":"RECEIVED"}}}
import { Examinee } from "./examinee";
import { Batch } from "./batch";

export class ExamineeBatchId{
    examineeId: number;
    batchId: number;
}

export class ExamineeBatch{
    examineeBatchIdPK: number;
    examineeBatchId: ExamineeBatchId;
    examineeBatchStartTime: string;
    examineeBatchEndTime: string;
    examineeBatchStatus: string;
    examinee: Examinee;
    batch: Batch;
}