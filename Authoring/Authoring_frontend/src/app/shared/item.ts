import { option } from "../shared/option";
import { course } from "../shared/course";
import { Tf } from "../shared/tf";


export class Item{
    itemText :string;
    cgLvl: string;
    diffLvl: string;
    marks: number;
    itemId: number;
    authorId: number;
    itemType:string;
    itemStatus:string;
    asItemMCQ: option[];
    reviewStatus: string;
    itemUseCount: string;
    asItemTF:Tf[];
    course:course[];
}



