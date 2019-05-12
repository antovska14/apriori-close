import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import { IIpUserResult } from "./most-frequent-comb/ip-user/ip-user-result";
import { IUser } from './user';

@Injectable({
  providedIn: "root"
})
export class OptionsService {
  private url: string = "api/";

  constructor(private http: HttpClient) {}

  public getMostFrequentUsersIpAddressCombinations(): Observable<
    IIpUserResult[]
  > {
    let optionUrl: string = "ip-user";
    return this.http
      .get<IIpUserResult[]>(this.url + optionUrl)
      .pipe(catchError(this.handleError));
  }

  public getMostCommonDiscussonUsers(): Observable<IUser[]>{
    let optionUrl: string = "discussion-users";
    return this.http.get<IUser[]>(this.url + optionUrl)
    .pipe(catchError(this.handleError));
  }

  private handleError(err: HttpErrorResponse): Observable<any> {
    let errorMessage = "";
    if (err.error instanceof ErrorEvent) {
      errorMessage = `An error occured ${err.error.message}`;
    } else {
      errorMessage = `Server returned code:${err.status}, error message is:${
        err.message
      }`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }
}
