import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Users } from '../users';



@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<Users>;
    public currentUser: Observable<Users>;

  constructor(private http: HttpClient) {
   }

   public get currentUserValue(): Users {
    return this.currentUserSubject.value;
  }
  apiURL: string = 'http://localhost:8765/observatory/api/';


 public  login(username: string, password: string) {
    return this.http.post<any>(`${this.apiURL}login`, { username, password })
        .pipe(map(user => {
            // login successful if there's a jwt token in the response
            if (user && user.token) {
              this.currentUser = this.currentUserSubject.asObservable();

              this.currentUserSubject = new BehaviorSubject<Users>(JSON.parse(localStorage.getItem('currentUser')));

                // store user details and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('currentUser', JSON.stringify(user));
                this.currentUserSubject.next(user);
                
            }

            return user;
        }));
  }

  
  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }




}
