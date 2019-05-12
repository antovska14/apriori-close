import { Component, OnInit, OnDestroy } from "@angular/core";
import { OptionsService } from "../../options.service";
import { IIpUserResult } from "./ip-user-result";
import { takeUntil } from "rxjs/operators";
import { Subject } from "rxjs";

@Component({
  selector: "app-ip-user",
  templateUrl: "./ip-user.component.html",
  styleUrls: ["./ip-user.component.css"]
})
export class IpUserComponent implements OnInit, OnDestroy {
  public result: IIpUserResult[];
  private unsubscribe: Subject<void> = new Subject<void>();

  constructor(private optionsService: OptionsService) {}

  ngOnInit() {
    this.getMostFrequentUsersIpAddressCombinations();
  }

  ngOnDestroy() {
    this.unsubscribe.next();
    this.unsubscribe.complete();
  }

  private getMostFrequentUsersIpAddressCombinations():void {
    this.optionsService
      .getMostFrequentUsersIpAddressCombinations()
      .pipe(takeUntil(this.unsubscribe))
      .subscribe(result => {
        this.result = <IIpUserResult[]>result;
      });
  }
}
