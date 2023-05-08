var map = L.map('map').setView([40.754085040909224, 14.529676579615334], 6);
var marker = L.marker([40.754085040909224, 14.529676579615334]).addTo(map);

/*L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: 'Mappa di © <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributori',
            maxZoom: 18
        }).addTo(map);*/


L.tileLayer('https://{s}.basemaps.cartocdn.com/rastertiles/voyager/{z}/{x}/{y}.png', {
            attribution: 'Mappa di © <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributori',
            maxZoom: 18
        }).addTo(map);

marker.bindPopup("<b>Nina</b>").openPopup();

var popup = L.popup();

function onMapClick(e) {
    popup
        .setLatLng(e.latlng)
        .setContent("Coordinate= " + e.latlng.toString())
        .openOn(map);
}

map.on('click', onMapClick);

