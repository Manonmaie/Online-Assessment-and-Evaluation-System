import { ExamineeBatch } from './examinee-batch';

export class Examinee{
    examineeId ?: number;
    examineeCode: string;
    examineeName: string;
    examineePassword: string;
    examineeBranch: string;
    examineeEmail: string;
    examineeCollege: string;
    examineeBatchList ?: ExamineeBatch[];
}