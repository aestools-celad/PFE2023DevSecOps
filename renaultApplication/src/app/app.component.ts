import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'renaultApplication';
  constructor(private http: HttpClient) { }

  isSideNavCollapsed = false;
  screenWidth = 0;

  onToggleSideNav(data: SideNavToggle): void {
    this.screenWidth = data.screenWidth;
    this.isSideNavCollapsed = data.collapsed;
  }

  
  ngOnInit()
  { 
  //  let resp = this.http.get("https://api.goingelectric.de/chargepoints/?key=19d974deee27be03459664d999989f0d&sw_lat=-87.71179927260242&sw_lng=-180&ne_lat=89.45016124669523&ne_lng=180&result_details%3Dminimal/");
    //resp.subscribe((data)=> console.log(data));
    
  }
}
