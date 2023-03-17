import { Injectable } from '@angular/core';
import { Geolocation, Position, PositionOptions } from '@capacitor/geolocation';
import { BehaviorSubject } from 'rxjs';
import { isNull } from 'util';


@Injectable({
  providedIn: 'root'
})
export class GpsService {

  // La posizione corrente dell'utente
  private currentPosition = new BehaviorSubject<Position>(null!);

  constructor() { }

  // Ottiene la posizione corrente dell'utente
  getCurrentPosition(): BehaviorSubject<Position> {
    // Opzioni per la richiesta di posizione
    const options: PositionOptions = {
      enableHighAccuracy: true,
      timeout: 5000,
      maximumAge: 0
    };

    // Richiede la posizione corrente del dispositivo
    Geolocation.getCurrentPosition(options).then((position) => {
      // Aggiorna la posizione corrente dell'utente
      this.currentPosition.next(position);
    }).catch((error) => {
      console.error('Errore nel recupero della posizione', error);
    });

    // Restituisce il BehaviorSubject della posizione corrente
    return this.currentPosition;
    
  }
  
}



