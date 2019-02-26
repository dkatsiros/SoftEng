import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css'],
})
export class NavigationComponent implements OnInit {

  constructor() { console.log("Navigation constructed");}

  ngOnInit() {
    console.log("Navigation init");
  }

  navigationWorks() {
    console.log("Hello from navigation");
  };
}
