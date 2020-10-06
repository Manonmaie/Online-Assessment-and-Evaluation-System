import { ItemMcqOption } from "./itemMcqOption";
import { ItemTrueFalse } from "./itemTrueFalse";

export class Examination{
    qpItemId: number;
    itemCode: string;
    itemText: string;
    itemMarks: number;
    itemType: string;
    cognitiveLevel: string;
    asItemMcqOptionsList: ItemMcqOption[];
    asItemTrueFalseList: ItemTrueFalse[];
}