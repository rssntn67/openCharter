let menu = document.querySelector('#menu-icon');
let navbar = document.querySelector('.navbar');

menu.onclick = () => {
    menu.classList.toggle('bx-x');
    navbar.classList.toggle('open');
}

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
     //${this.id}, Name: ${this.name}, Tipo: ${this.tipo}, Nazione: ${this.nazione}, Portorif: ${this.portorif}, Armatore: ${this.armatore}, Proprietario: ${this.proprietario}, Lung: ${this.lung}, Larg: ${this.larg}, Alt: ${this.alt};

toString() {
    return ("<br><strong>NAVE "+this.id+"</strong><br>Nome= "+this.name+"<br>Tipo di imbarcazione= "+this.tipo+"<br>Nazione= "+this.nazione+"<br>Porto di riferimento= "+this.portorif+"<br>Armatore= "+this.armatore+"<br>Propretario= "+this.proprietario+"<br>Lunghezza= "+this.lung+"m<br>Larghezza= "+this.larg+"m<br>Altezza= "+this.alt+"m");
  }
}




function iniNave() {
  var num = 1;
  var xhr = new XMLHttpRequest();
  var outputDiv = document.getElementById('id01');
  var stringa = "";

  function sendRequest(stringa) {
    xhr.open('GET', 'http://localhost:9001/navi/' + num);
    xhr.send();

    xhr.onload = function() {
      if (xhr.status !== 200) {
        // Gestisci altri tipi di errori se necessario
        return;
      }

      var response = JSON.parse(xhr.responseText);

      var obj = new Nave(
        response.id,
        response.name,
        response.tipo,
        response.nazione,
        response.portorif,
        response.armatore,
        response.proprietario,
        response.lung,
        response.larg,
        response.alt
      );

      console.log(obj.toString());
      stringa += obj.toString() + "<br>";
      outputDiv.innerHTML = stringa;
      outputDiv.classList.add('show');

      num++;
      sendRequest(stringa); // Chiamata ricorsiva per effettuare la successiva richiesta
    };
  }

  sendRequest(stringa); // Prima chiamata alla funzione sendRequest con stringa inizialmente vuota
}