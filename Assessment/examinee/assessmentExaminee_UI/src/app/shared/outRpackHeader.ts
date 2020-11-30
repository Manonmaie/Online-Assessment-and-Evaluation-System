import { Rpack1 } from "./rpack1";

export class OutRpackHeader {
    rpackHeaderId: number;
    rpackDesc: string;
    createdBy: string;
    rpackPath: string;
    createdOn: string;
    rpackSentOn: string;
    rpackStatus: string;
    rpack1List: Rpack1[];
}