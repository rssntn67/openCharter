export class Nave {
    id:number | undefined;
    name:string;
    tipo:string;
    nazione:string;
    portorif:string;
    armatore:string | undefined;
    proprietario:string | undefined;
    lung:number| undefined;
    larg:number| undefined;
    alt:number| undefined;

    constructor(name:string,tipo:string,nazione:string,portorif:string){
    this.name=name;
    this.tipo=tipo;        
    this.nazione=nazione;
    this.portorif=portorif;
    }
    setArmatore(armatore:string){
        this.armatore=armatore;
    }
    setProprietario(proprietario:string){
        this.proprietario=proprietario;
    }
    setSize(lung:number, larg:number, alt:number){
        this.lung=lung;
        this.larg=larg;
        this.alt=alt;
    }
    setId(id:number){
        this.id=id;
    }
}



