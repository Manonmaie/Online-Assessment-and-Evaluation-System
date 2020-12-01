import { Mpack1 } from "./mpack1";

export class OutMpackHeader {
    mpackHeaderId: number;
    mpackDesc: string;
    createdBy: string;
    rpackPath: string;
    createdOn: string;
    mpackSentOn: string;
    mpackStatus: string;
    mpack1List: Mpack1[];
}