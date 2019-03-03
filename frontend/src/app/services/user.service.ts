import { Injectable } from '@angular/core';
import { Users} from '../users';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
  apiURL: string = 'http://localhost:8765/observatory/api/';

  register(user: Users) {
    console.log(user);
    return this.http.post(`${this.apiURL}register`, user);
  } 
}
