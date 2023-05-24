let menu = document.querySelector('#menu-icon');
let navbar = document.querySelector('.navbar');

var map = L.map('map').setView([40.754085040909224, 14.529676579615334], 6);

/*L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: 'Mappa di © <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributori',
            maxZoom: 18
        }).addTo(map);*/


L.tileLayer('https://{s}.basemaps.cartocdn.com/rastertiles/voyager/{z}/{x}/{y}.png', {
            attribution: 'Mappa di © <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributori',
            maxZoom: 18
        }).addTo(map);

var popup = L.popup();

function onMapClick(e) {
    popup
        .setLatLng(e.latlng)
        .setContent("Coordinate= " + e.latlng.toString())
        .openOn(map);
}

map.on('click', onMapClick);

menu.onclick = () => {
    menu.classList.toggle('bx-x');
    navbar.classList.toggle('open');
}



//-----------------------------------------------------/ /
class Info {
    id;
    idnave;
    data;
    lat;
    lon;

    constructor(id,idnave,data,lat,lon){
        this.id=id;
        this.idnave=idnave;
        this.data=data;
        this.lat=lat;
        this.lon=lon;
    }
    
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
}


function iniNave()
{
    var Icona = L.Icon.extend({
      options: { 
        iconSize:     [32, 32], // size of the icon
        shadowSize:   [0, 0], // size of the shadow
        iconAnchor:   [22, 22], // point of the icon which will correspond to marker's location
        shadowAnchor: [4, 62],  // the same for the shadow
        popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
    }
});

  var peschereccio = new Icona({iconUrl: 'peschereccio.png'}),
    crociera = new Icona({iconUrl: 'crociera.png'});

  var num = 1;
  var xhr = new XMLHttpRequest();
  var xhr1 = new XMLHttpRequest();

  function sendRequest() {


    xhr1.open('GET', 'http://localhost:9001/navi/' + num);
    xhr1.send();


    xhr.open('GET', 'http://localhost:9001/info/' + num);
    xhr.send();

    xhr.onload = xhr1.onload = function() {
      if (xhr.status !== 200 || xhr1.status !=200) {
        // Gestisci altri tipi di errori se necessario
        return;
      }


      var response = JSON.parse(xhr.responseText);
      var response1 = JSON.parse(xhr1.responseText);

      var obj1 = new Nave(
        response1.id,
        response1.name,
        response1.tipo,
        response1.nazione,
        response1.portorif,
        response1.armatore,
        response1.proprietario,
        response1.lung,
        response1.larg,
        response1.alt
      );
      var obj = new Info(
        response.id,
        response.idnave,
        response.data,
        response.lat,
        response.lon,
      );


      console.log(obj1.tipo);

      switch(obj1.tipo)
      {
         case 'Peschereccio':
             L.marker([obj.lat, obj.lon], {icon: peschereccio}).addTo(map).bindPopup("<b>" + obj1.name +"</b>").openPopup();
             break;
         case 'Crociera':
             L.marker([obj.lat, obj.lon], {icon: crociera}).addTo(map).bindPopup("<b>" + obj1.name +"</b>").openPopup();
             break;
      }





      num++;
      sendRequest(); // Chiamata ricorsiva per effettuare la successiva richiesta
    };
  }

  sendRequest(); // Prima chiamata alla funzione sendRequest con stringa inizialmente vuota
}