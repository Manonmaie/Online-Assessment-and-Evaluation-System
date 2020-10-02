// {"":2,"":"Attempt2","":1,"":"2020-09-27T14:00:00","":"2020-09-27T17:00:00","":"COMPLETED","asExamineeBatch":{"examineeBatchId":{"examineeId":2,"batchId":1},"examinee":{"examineeId":2,"examineeCode":"S2","examineeName":"XYZ","examineePassword":"xyz","examineeBranch":null,"examineeEmail":null,"examineeCollege":null},"batch":{"batchId":1,"batchCode":"Mrng1","batchStartTime":"2020-09-27T14:00:00","batchEndTime":"2020-09-27T23:00:00","qpStatus":"RECEIVED"}}}
import { ExamineeBatch } from "./examineeBatch";

export class Attempt{
    attemptId: number;
    attemptCode: string;
    attemptNumber: number;
    attemptStartTime: string;
    attemptEndTime: string;
    attemptStatus: string;
    asExamineeBatch: ExamineeBatch;
}