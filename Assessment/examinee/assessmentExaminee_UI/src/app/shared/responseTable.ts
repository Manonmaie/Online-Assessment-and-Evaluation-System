// {"responseId":0,"asQpItem":{"qpItemId":1,"itemCode":"Item1_qp1","itemText":"What is a database?","itemMarks":2.0,"itemType":"McqSingleCorrect","cognitiveLevel":"UNDERSTAND","asItemMcqOptionsList":[{"itemMcqId":1,"itemMcqOptionsCode":"Mcq1_item1_qp1","mcqOptionText":"Collection of related data"},{"itemMcqId":2,"itemMcqOptionsCode":"Mcq2_item1_qp1","mcqOptionText":"Collection of data"},{"itemMcqId":3,"itemMcqOptionsCode":"Mcq3_item1_qp1","mcqOptionText":"Collection of words"},{"itemMcqId":4,"itemMcqOptionsCode":"Mcq4_item1_qp1","mcqOptionText":"Collection of people"}],"asItemTrueFalseList":[]},"asAttempt":{"attemptId":1,"attemptNumber":1,"attemptStartTime":"2020-09-27T14:00:00","attemptEndTime":"2020-09-27T17:00:00","attemptStatus":"COMPLETED","asExamineeBatch":{"examineeBatchId":{"examineeId":1,"batchId":1},"examineeBatchStartTime":null,"examineeBatchEndTime":null,"examineeBatchStatus":"NOT_STARTED"}},"asResponseMcq":{"responseMcqId":0,"responseText":"Collection of related data"}}
import { Examination } from "./examination";
import { Attempt } from "./attempt";

export class ResponseTable{
    responseId: number;
    asQpItem: Examination;
    asAttempt: Attempt;
    responseText: string;
}