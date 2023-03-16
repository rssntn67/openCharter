import { Geolocation } from '@capacitor/geolocation';
import { Component, OnInit } from '@angular/core';
import { CapacitorGoogleMaps } from '@capacitor-community/capacitor-google-maps';



@Component({
  selector: 'app-map',
  templateUrl: './map.page.html',
  styleUrls: ['./map.page.scss'],
})
export class MapPage implements OnInit {

  constructor() { }

  async ngOnInit() {
    // Ottiene la posizione corrente dell'utente
    const position = await Geolocation.getCurrentPosition();

    // Inizializza la mappa
    CapacitorGoogleMaps.initialize({
      key: 'GOOGLE_MAPS_API_KEY' // sostituire con la propria chiave API Google Maps
    });

    // Crea una mappa centrata sulla posizione corrente dell'utente
    const map = CapacitorGoogleMaps.createMap({
      divId: 'map',
      camera: {
        target: {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        },
        zoom: 15
      }
    });

    // Aggiunge un marker sulla posizione corrente dell'utente
    const marker = CapacitorGoogleMaps.createMarker({
      position: {
        lat: position.coords.latitude,
        lng: position.coords.longitude
      },
      map: map
    });
  }
}
