import { ExamineeBatchKey } from './examinee-batch-key';
import { Batch } from './batch';
import { Examinee } from './examinee';

export class ExamineeBatch{
    examineeBatchId: ExamineeBatchKey;
    marksObtained: number;
    examinee: Examinee;
    batch: Batch;
}