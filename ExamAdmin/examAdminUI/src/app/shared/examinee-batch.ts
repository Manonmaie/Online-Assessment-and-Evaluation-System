import { ExamineeBatchKey } from './examinee-batch-key';
import { Batch } from './batch';

export class ExamineeBatch{
    examineeBatchId: ExamineeBatchKey;
    marksObtained: number;
    batch: Batch;
}