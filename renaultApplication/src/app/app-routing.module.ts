import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChargeLocationComponent } from './components/charge-location/charge-location.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { MapComponent } from './components/map/map.component';
import { SettingsComponent } from './components/settings/settings.component';

const routes: Routes = [
  {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
  {path: 'dashboard', component: DashboardComponent},

  {path: 'map', component: MapComponent},
  {path: 'chargeLocation', component: ChargeLocationComponent},
  {path: 'settings', component: SettingsComponent}

];

@NgModule({
  
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
