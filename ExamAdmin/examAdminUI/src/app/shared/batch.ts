import { Center } from './center';
import { Examdrive } from './examdrive';

export class Batch{
    batchId ?: number;
    batchCode: string;
    qpStatus: string;
    batchStartTime: string;
    batchEndTime: string;
    center: Center;
}