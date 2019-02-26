import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  page = {
    title: 'Home',
    subtitle: 'Welcome Home!',
    content: 'Some home content.'
    // image: 'assets/bg00.jpg'
  };
}
