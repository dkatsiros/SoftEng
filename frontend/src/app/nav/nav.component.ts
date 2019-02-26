import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  appTitle:string = "eCoffee"
  title1:string =  "Home"
  title2:string =  "About"
  title3:string =  "Sign in"
}
