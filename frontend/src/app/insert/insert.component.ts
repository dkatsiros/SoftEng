import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

export const token: string = 'jwt_token';
@Component({
  selector: 'app-insert',
  templateUrl: './insert.component.html',
  styleUrls: ['./insert.component.css']
})
export class InsertComponent implements OnInit {

  g() { localStorage.getItem(token); }

  constructor() { }
  ngOnInit() {
  }
  title1:string =  "Insert Product"
  title2:string =  "Insert Shop"
  title3:string =  "Insert Price"

}
