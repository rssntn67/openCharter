import { StringifyOptions } from "querystring";

export class Info {
    id:number;
    lat:number;
    long:number;
    idnave:string;
    data:Date;

    constructor(id:number,lat:number, long:number,idnave:string,data:Date){
        this.id=id;
        this.lat=lat;
        this.long=long;
        this.idnave=idnave;
        this.data=data;
    }
    
}

