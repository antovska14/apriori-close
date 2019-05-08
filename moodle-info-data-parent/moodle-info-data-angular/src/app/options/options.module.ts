import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OptionsRoutingModule } from './options-routing.module';
import { IpUserComponent } from './most-frequent-comb/ip-user/ip-user.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [IpUserComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    OptionsRoutingModule
  ]
})
export class OptionsModule { }
