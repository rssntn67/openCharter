import { ErrorHandler, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule} from '@angular/common/http'; 
import { RestProvider } from './providers/rest/rest';
import { StatusBar } from '@capacitor/status-bar';
@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule, HttpClientModule],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy }],
  bootstrap: [AppComponent],
  provider:[
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler,useClass: ErrorHandler},
    RestProvider //this is our provider entry
  ]
})
export class AppModule {}
