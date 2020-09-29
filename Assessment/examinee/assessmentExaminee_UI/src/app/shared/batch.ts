// "batch":{"":1,"":"Mrng1","":"2020-09-27T14:00:00","":"2020-09-27T23:00:00","":"RECEIVED"}}}
import { CourseMaster } from "./courseMaster";

export class Batch{
    batchId: number;
    batchCode: string;
    batchStartTime: string;
    batchEndTime: string;
    qpStatus: string;
    asCourseMaster: CourseMaster;
}