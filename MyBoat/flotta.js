class Nave {
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
    return `ID: ${this.id}, Name: ${this.name}, Tipo: ${this.tipo}, Nazione: ${this.nazione}, Portorif: ${this.portorif}, Armatore: ${this.armatore}, Proprietario: ${this.proprietario}, Lung: ${this.lung}, Larg: ${this.larg}, Alt: ${this.alt}`;
  }
    
}

/*function httpGet(theUrl, callback)
{
    console.log(theUrl);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            console.log(xmlHttp.statusText);
            console.log(xmlHttp.response);
            console.log(xmlHttp.responseType);
            callback(xmlHttp.response);
        }
    };
    xmlHttp.open( "GET", theUrl, true ); // false for synchronous request
    xmlHttp.setRequestHeader('Access-Control-Allow-Headers', '*');
    xmlHttp.setRequestHeader('Content-type', 'application/json');
    xmlHttp.setRequestHeader('Access-Control-Allow-Origin', '*');
    xmlHttp.responseType = 'json'
    xmlHttp.send(null);
}*/


function iniNave()
{
    nave1 = new Nave(1, 'Nave1', 'Tipo1', 'Nazione1', 'PortoRif1', 'Armatore1', 'Proprietario1', 50, 10, 5);
    console.log(nave1.toString());

    fetch('http://localhost:9001/navi')
  .then(response => response.json())
  .then(data => {
    // Passa i dati al costruttore della tua classe
    const dataArray = Array.from(data); // Converti in un array
    const n = dataArray.map(obj => new Nave(
      obj.id,
      obj.name,
      obj.tipo,
      obj.nazione,
      obj.portorif,
      obj.armatore,
      obj.proprietario,
      obj.lung,
      obj.larg,
      obj.alt
    ));
    n.map(Nave => console.log(Nave.toString()));
  })
  .catch(error => console.error(error));
}

