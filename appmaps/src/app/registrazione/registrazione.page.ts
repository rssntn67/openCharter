import { Component, OnInit } from '@angular/core';
import { MyboatserviceService } from '../services/myboatservice.service';
import { Nave } from '../model/nave';
@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.page.html',
  styleUrls: ['./registrazione.page.scss'],
})
export class RegistrazionePage implements OnInit {
boat:Nave |undefined;
id:string |undefined;
  constructor(public service:MyboatserviceService) { }

  async ngOnInit() {
   // await this.service.loadid();
  this.boat = this.service.getNaveById('1').forEach.apply;
  }
  

}
