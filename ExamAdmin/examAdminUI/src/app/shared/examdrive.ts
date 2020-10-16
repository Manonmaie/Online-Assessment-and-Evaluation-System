import { Batch } from './batch';
import { Course } from './course';

export class Examdrive{
    examdriveId ?: number;
    examdriveCode: string;
    examdriveName: string;
    status: string;
    course: Course;
    batchList ?: Batch[];
}