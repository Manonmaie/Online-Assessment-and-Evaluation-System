import { Item } from "../shared/item";
import { course } from './course';

export class QP{
    course :course; // course id
    totalMarks: Number;
    timeDuration: Number;
    items: Item[];
    batchCode: string;
    inst: string[]; // instructions
}