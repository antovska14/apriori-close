import { Component, OnInit, OnDestroy } from "@angular/core";
import { OptionsService } from "../../options.service";
import { IIPUserResult } from "./ip-user-result";
import { takeUntil } from "rxjs/operators";
import { Subject } from "rxjs";

@Component({
  selector: "app-ip-user",
  templateUrl: "./ip-user.component.html",
  styleUrls: ["./ip-user.component.css"]
})
export class IpUserComponent implements OnInit, OnDestroy {
  public users: IIPUserResult[];

  private unsubscribe: Subject<void> = new Subject<void>();

  constructor(private optionsService: OptionsService) {}

  ngOnInit() {
    this.getMostFrequentUsersIpAddressCombinations();
  }

  ngOnDestroy() {
    this.unsubscribe.next();
    this.unsubscribe.complete();
  }

  private getMostFrequentUsersIpAddressCombinations() {
    this.optionsService
      .getMostFrequentUsersIpAddressCombinations()
      .pipe(takeUntil(this.unsubscribe))
      .subscribe(users => {
        this.users = <IIPUserResult[]>users;
      });
  }
}
