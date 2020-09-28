import { ItemMcqOption } from "./itemMcqOption";

export class Examination{
    qpItemId: number;
    itemCode: string;
    itemText: string;
    itemMarks: number;
    itemType: string;
    cognitiveLevel: string;
    asItemMcqOptionsList: ItemMcqOption[];
}