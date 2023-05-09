export class Nave {
    id;
    name;
    tipo;
    nazione;
    portorif;
    armatore;
    proprietario;
    lung;
    larg;
    alt;

    constructor(id,name,tipo,nazione,portorif,armatore,proprietario,lung,larg,alt){
        this.id=id;
        this.name=name;
        this.tipo=tipo;
        this.nazione=nazione;
        this.portorif=portorif;
        this.armatore=armatore;
        this.proprietario=proprietario;
        this.lung=lung;
        this.larg=larg;
        this.alt=alt;
    }

    toString() {
    return ("Nome= "+this.name);
  }
    
}