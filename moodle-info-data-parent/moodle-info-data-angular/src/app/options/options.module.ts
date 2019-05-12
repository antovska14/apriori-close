import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { OptionsRoutingModule } from "./options-routing.module";
import { IpUserComponent } from "./most-frequent-comb/ip-user/ip-user.component";
import { HttpClientModule } from "@angular/common/http";
import { DiscussionUsersComponent } from "./other/discussion-users/discussion-users.component";

@NgModule({
  declarations: [IpUserComponent, DiscussionUsersComponent],
  imports: [CommonModule, HttpClientModule, OptionsRoutingModule]
})
export class OptionsModule {}
