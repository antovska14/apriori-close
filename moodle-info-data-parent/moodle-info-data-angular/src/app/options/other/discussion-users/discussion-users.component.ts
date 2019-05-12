import { Component, OnInit, OnDestroy } from '@angular/core';
import { IUser } from '../../user';
import { OptionsService } from '../../options.service';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-discussion-users',
  templateUrl: './discussion-users.component.html',
  styleUrls: ['./discussion-users.component.css']
})
export class DiscussionUsersComponent implements OnInit, OnDestroy {
  public users: IUser[];
  private unsubscribe: Subject<void> = new Subject<void>();
  
  constructor(private optionsService: OptionsService) { }

  ngOnInit() {
    this.getMostCommonDiscussonUsers();
  }

  ngOnDestroy(){
    this.unsubscribe.next();
    this.unsubscribe.complete();
  }

  private getMostCommonDiscussonUsers(): void{
    this.optionsService.getMostCommonDiscussonUsers()
        .pipe(takeUntil(this.unsubscribe))
        .subscribe(users => {
          this.users = <IUser[]>users;
        })
  }
}
