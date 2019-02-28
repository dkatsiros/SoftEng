import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';

@Injectable({
providedIn: 'root'
})

export class JwtService {
    constructor(private httpClient: HttpClient) { }
    apiURL: string = 'https://localhost:8765/observatory/api/';


  login(username:string, password:string) {
    return this.httpClient.post<{access_token:  string}>(`${this.apiURL}/login`, {username, password}).pipe(tap(res => {
    localStorage.setItem('access_token', res.access_token);
  }))
  }

  register(username:string, name:string, email:string, password:string) {
    return this.httpClient.post<{access_token: string}>(`${this.apiURL}/register`, {username,name,email,password}).pipe(tap(res => {
    this.login(username, password);

    alert('something');
    }))
  }
  logout() {
    localStorage.removeItem('access_token');
  }
  public get loggedIn(): boolean{
    return localStorage.getItem('access_token') !==  null;
  }
}