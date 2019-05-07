import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import { IIPUserResult } from "./most-frequent-comb/ip-user/ip-user-result";

@Injectable({
  providedIn: "root"
})
export class OptionsService {
  private mostFrequentUsersIpAddressCombinationUrl = "api/example";

  constructor(private http: HttpClient) {}

  public getMostFrequentUsersIpAddressCombinations(): Observable<
    IIPUserResult[]
  > {
    return this.http
      .get<IIPUserResult[]>(this.mostFrequentUsersIpAddressCombinationUrl)
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
