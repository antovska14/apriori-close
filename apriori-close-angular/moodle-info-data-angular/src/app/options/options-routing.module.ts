import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IpUserComponent } from './most-frequent-comb/ip-user/ip-user.component';

const routes: Routes = [
  {path:'ip-user', component:IpUserComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OptionsRoutingModule { }
