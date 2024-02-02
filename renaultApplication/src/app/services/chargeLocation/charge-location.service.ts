import { HttpClient, HttpHeaders, HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, of, tap } from 'rxjs';
//import { environment } from 'src/environments/environment';
import { environment } from 'src/environments/environment.prod';

import { ChargeLocation } from '../../models/ChargeLocation';

const cors = require('cors');

const headers = new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');
@Injectable({
  providedIn: 'root'
})
export class ChargeLocationService {
  private apiServerUrl = environment.apiBaseUrl;
  apiResponse: any;
  

  constructor(private http: HttpClient) { }
  tesst(){
    return this.http.get('http://localhost:8080/api/ge/chargelocation_all/')
    }
//    return this.http.get<ChargeLocation[]>(`${this.apiServerUrl}/api/ge/chargelocations_all/?page=1&size=10&sort=name,asc`);

  public getLocation(): Observable<ChargeLocation[]>
  {
    return this.http.get<ChargeLocation[]>(`${this.apiServerUrl}/api/ge/chargelocations_all`);
  }

  public getLocation_ocm(): Observable<ChargeLocation[]>
  {
    return this.http.get<ChargeLocation[]>(`${this.apiServerUrl}/api/chargelocations_all_ocm`);
  }



 /* public getLocation_byCountry(country : string): Observable<ChargeLocation[]>
  {   
    const params = new HttpParams().set('country', country);

     this.http.get<any>('/api/ge/chargelocations_country', { params }).subscribe((response) => {
           
        this.apiResponse = response;
  
      });
      return this.apiResponse ;
         

    
  }*/
  public getLocation_byCountry(country: string): Observable<ChargeLocation[]> {   
    const params = new HttpParams().set('country', country);
  
    return this.http.get<ChargeLocation[]>('/api/ge/chargelocations_country', { params });
  }

  public getLocation_byCountry_ocm(country: string): Observable<ChargeLocation[]> {   
    const params = new HttpParams().set('country', country);
  
    return this.http.get<ChargeLocation[]>('/api/chargelocations_country', { params });
  }
  

  public addLocation(chargeLocation :ChargeLocation): Observable<ChargeLocation>
  {
    return this.http.post<ChargeLocation>('${this.apiServerUrl}/ge/add_chargelocation',chargeLocation);
  }

  public deleteLocation(locationId :number): Observable<void>
  {
    return this.http.delete<void>('${this.apiServerUrl}/ge/delete_chargelocations/${locationId }');
  }
  public getChargePoint() : Observable<ChargeLocation[]>
  {
    return this.http.get<ChargeLocation[]>(`https://api.goingelectric.de/chargepoints/?key=19d974deee27be03459664d999989f0d&sw_lat=-87.71179927260242&sw_lng=-180&ne_lat=89.45016124669523&ne_lng=180&result_details%3Dminimal`)
 
  }
  
}
