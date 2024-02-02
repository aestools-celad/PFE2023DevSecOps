import { Injectable } from '@angular/core';

declare const H: any;

@Injectable({
  providedIn: 'root'
})
export class HereService {
  private platform: any;
  private geocoder: any;

  constructor() {
    this.platform = new H.service.Platform({
      apikey: 'W0T-hep-BOCZg3QniSjBDw '
    });
    this.geocoder = this.platform.getSearchService();
  }

  geocode(query: string): Promise<any> {
    return new Promise((resolve, reject) => {
      this.geocoder.geocode({ q: query }, (result: any) => {
        if (result.items.length > 0) {
          resolve(result.items[0]);
        } else {
          reject(new Error('No results found'));
        }
      }, (error: any) => {
        reject(error);
      });
    });
  }
}
