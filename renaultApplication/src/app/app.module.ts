import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpHeaders, HttpParams ,HttpInterceptor, HttpEvent, HttpHandler, HttpRequest,HTTP_INTERCEPTORS} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MapComponent } from './components/map/map.component';
import { HttpClientModule } from '@angular/common/http';
import { ChargeLocationComponent } from './components/charge-location/charge-location.component';
import * as cors from 'cors';
import { ChargeLocationService } from './services/chargeLocation/charge-location.service';
import { BodyComponent } from './components/body/body.component';
import { SidenavComponent } from './components/sidenav/sidenav.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { SettingsComponent } from './components/settings/settings.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TokenInterceptorService } from './services/token-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    MapComponent,
    ChargeLocationComponent,
    BodyComponent,
    SidenavComponent,
    DashboardComponent,
    SettingsComponent,
    ChargeLocationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HttpClientModule,
    CommonModule,
    BrowserAnimationsModule

    
  ],
  providers: [
 
    ChargeLocationService,
    {
      provide : HTTP_INTERCEPTORS,
      useClass : TokenInterceptorService ,
      multi :true
 
   },
   // { provide: cors, useValue: { origin: 'http://localhost:4200' } }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
