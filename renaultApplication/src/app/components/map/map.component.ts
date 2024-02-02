import { Component, Input, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { ChargeLocation } from 'src/app/models/ChargeLocation';
import { FeatureCollection } from 'geojson';
import * as L from 'leaflet';
import "leaflet-routing-machine";
import { ChargeLocationService } from 'src/app/services/chargeLocation/charge-location.service';
import { map} from 'rxjs';

// the coordinates of Malta
export const DEFAULT_LAT = 35.8978;
export const DEFAULT_LON =  14.5125;
export const TITULO = 'project';
const iconRetinaUrl = 'assets/marker-icon-2x.png';
const iconUrl = 'assets/marker-icon.png';
const shadowUrl = 'assets/marker-shadow.png';

declare const H: any;
const cors = require('cors');
@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit  {
   latitude !: number;
longitude!: number;

  accuracy!: number ;
  places : any =[];
  chargelocations: ChargeLocation[] = [];
  private markers: L.Marker[] = [];

  private marker: any ;


  private map:any;
  @Input() lat: number = DEFAULT_LAT;
  @Input() lon: number = DEFAULT_LON;
  @Input() titulo: string = TITULO ;
  constructor(private http: HttpClient ,private locationService : ChargeLocationService) { }

  ngOnInit(): void {
    this.initMap();
    this.CountryMarkers();
    this.locationService.tesst();
  
   }


  //////////////////////////////Initialisation of the map and open it in Malta //////////////////////////////////

   
  public initMap(): void {
    
this.map = L.map('map-container').setView([35.8978, 14.5125], 14);
L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
  attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
    '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
    'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
  maxZoom: 18,
  id: 'mapbox/streets-v11',
  tileSize: 512,
  zoomOffset: -1,
  accessToken: 'pk.eyJ1IjoiaG91ZGExOTk5IiwiYSI6ImNsZXl1OTg4NjFseXgzd21rb2h1ejk0NWUifQ.aAzLEPTLd2fXf_AiLlag0Q'
}).addTo(this.map);
const latlng = {
  lat: 35.8978,
  lng: 14.5125
};

fetch(`https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=${35.8978}&lon=${14.5125}`)
  .then(response => response.json())
  .then(data => {
    const city = data.display_name;
    const country = data.address.country;

    const marker = L.marker(latlng ,
      {
        icon: L.icon({
          iconUrl: 'assets/eco-car.png',
          iconSize: [25, 41],
          iconAnchor: [12, 41]
        })
      }).addTo(this.map);
    marker.bindPopup(`${city}, ${country}`).openPopup();
  });
  /*const button = L.Control.extend({
    options: {
      position: 'topright'
    },
    onAdd: function() {
      const div = L.DomUtil.create('div', 'button');
      div.innerHTML = '  <button  (click)="findNearestChargeLocation()">Find Nearest Charge Location</button>';
      return div;
    }
  });*/

//  this.map.addControl(new button());


this.locationService.getLocation().pipe(
  map(locations => Object.values(locations)), // convert object to array
 
  map((locations: ChargeLocation[]) => {
   
    console.log(locations); // 
    console.log('location of 20 arrays' ,locations[0]);//20
    this.places = locations[0] ;
    
     if (!Array.isArray(locations)) {
       throw new Error('Locations is not an array');
     }
     const features = this.places.map((location: ChargeLocation) => {
      
     

      // create a GeoJSON feature for each ChargeLocation object
       return {
         type: 'Feature',
         geometry: {
           type: 'Point',
           coordinates:  [location.lng, location.lat]
         },
         properties: {
           name: location.name,
           address: location.country,
           // add any other properties you need
         }

       };

     });
     console.log(features);


     // create a FeatureCollection object that contains all the features
     return {
       type: 'FeatureCollection',
       features: features
     } as FeatureCollection;
   })
 ).subscribe((geojson: FeatureCollection) => {
   // use the converted GeoJSON object here
   console.log(geojson.features)
   const markers = L.geoJSON(geojson, {
     onEachFeature: (feature, layer) => {
      // get the latitude and longitude coordinates
     // const [lng, lat] = feature.geometry.coordinates;
     if (feature.geometry.type === 'Point') {
      const lng = feature.geometry.coordinates[0];
      const lat = feature.geometry.coordinates[1];
      layer.bindPopup(`<b>${feature.properties.name}</b><br>Latitude: ${lat}<br>Longitude: ${lng}`);
    } 
     }
   });
   // add the GeoJSON layer group to the map
   markers.addTo(this.map);
    
 });
 

//////////////////////////////////////////////////////

    //iconos personalizados
    var iconDefault = L.icon({
      iconRetinaUrl,
      iconUrl,
      shadowUrl,
      iconSize: [25, 41],
      iconAnchor: [12, 41],
      popupAnchor: [1, -34],
      tooltipAnchor: [16, -28],
      shadowSize: [41, 41]
    });
   L.Marker.prototype.options.icon = iconDefault;
   

  
    //titulo
    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 10,
      attribution: '&copy; <a href="https://1938.com.es">Web Inteligencia Artificial</a>'
    });

    
   
  }
////////////////////add the markers of charges locations of the country (Maltta in our case) and return the route of the nearest position  ///////////////////////////////////
public CountryMarkers()
{
  const userLatLng = L.latLng(35.8978,14.5125);
  console.log('hellllllllllllllllllllllllooo this is my initial posistion',userLatLng);

  this.locationService.getLocation_byCountry('Malta').subscribe((chargelocations: ChargeLocation[]) => {
    console.log(chargelocations);
     
    // check if the chargelocations array is defined
    if (chargelocations) {
      // iterate through the chargelocations array and create a marker for each country
      console.log('Iterating over chargelocations...');
      chargelocations.forEach(chargelocation => {
        const latlng = { lat: chargelocation.lat, lng: chargelocation.lng };


        const marker = L.marker(latlng,
          {
            icon: L.icon({
              iconUrl: 'assets/chargeMarker.png',
              iconSize: [25, 41],
              iconAnchor: [12, 41]
            })
          }
          
          ).addTo(this.map);

          
          const popupContent = `
          <b>
          ${chargelocation.city}<br>
          ${chargelocation.street}<br>
          ${chargelocation.name}
        `;
  
        marker.bindPopup(popupContent);
        this.markers.push(marker);
   });}
   var nearestChargeLocation: L.Marker<any> | null = null;
   let nearestChargeDistance = Infinity;
   if (this.markers && this.markers.length > 0) {
    // Initialize nearestChargeLocation to the first marker
    nearestChargeLocation = this.markers[0];
    nearestChargeDistance = userLatLng.distanceTo(nearestChargeLocation.getLatLng());
  
    // Iterate over the rest of the markers to find the nearest one
    for (let i = 1; i < this.markers.length; i++) {
      const marker = this.markers[i];
      const chargeLatLng = marker.getLatLng();
      const distance = userLatLng.distanceTo(chargeLatLng);
  
      if (distance < nearestChargeDistance) {
        nearestChargeLocation = marker;
        nearestChargeDistance = distance;
      }
    }
  
    const nearestChargeLatLng = nearestChargeLocation.getLatLng();
    console.log(nearestChargeLatLng)
    const routingControl = L.Routing.control({
      waypoints: [
        L.latLng(35.8978, 14.5125), // Starting point
        nearestChargeLatLng // Ending point
      ],
      routeWhileDragging: true
    }).addTo(this.map);
  
    nearestChargeLocation.openPopup();
  } else {
    console.log("No charge locations found.");
  }
  
   });
   
}

   //////////////this function give u your current location but I didn't use it cuz in this database which is extracted from goingElectric we don't have the coordinates od the charges loctaions in tunisia it works only in EUROPE///////////////////      
 /* getLocation() {
    let country :string; 
    let city ;
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(position => {
        const latlng = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        };
        this.map.setView(latlng, 13);

        const marker1 = L.marker(latlng).addTo(this.map);
        console.log(latlng);
           fetch(`https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=${latlng.lat}&lon=${latlng.lng}`)
          .then(response => response.json())
          
          .then(data => {
            city = data.display_name;
            country = data.address.country;
            console.log(data.address.country)
            console.log(city)
            console.log(data)
            console.log(typeof(country))

            const popup = L.popup()
              .setLatLng(latlng)
              .setContent(`${city}, ${country}`)
              .openOn(this.map);


              })   
    
  })
    
}
 }

 public clearMarkers(): void {
  this.markers.forEach(marker => marker.remove());
  this.markers = [];
}*/
}
  
  
  
  
  

