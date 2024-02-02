import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ChargeLocationService } from 'src/app/services/chargeLocation/charge-location.service';
import { ChargeLocation } from 'src/app/models/ChargeLocation';
import { map } from 'rxjs';
import { FeatureCollection } from 'geojson';
import * as L from 'leaflet';
import { Feature } from 'src/app/models/Feature';

@Component({
  selector: 'app-charge-location',
  templateUrl: './charge-location.component.html',
  styleUrls: ['./charge-location.component.css']
})

export class ChargeLocationComponent implements OnInit{

  public locations: ChargeLocation[] = [];
  public chargePoint: ChargeLocation[] = [];
  places : any =[];
  data = {};
  data1= {}
  // define an interface for the feature object


// initialize the features array as an empty array of Feature objects
features: Feature[] = [];


  constructor (private locationService : ChargeLocationService)
  {  }
  ngOnInit(): void {
    this.getLocation();
    this.locationService.tesst().subscribe((res)=>{
      console.log("//////////////////////////////",res)
    })  }
  public getLocation() : void { 
   
  }
  

}
