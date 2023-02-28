import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  tiles = [
    {
      title: 'Confirmed Layovers',
      route: '',
      titleFull: 'Confirmed Layovers Planning',
      description: 'Plan and check all consumable and expendable routine requirements for upcoming layovers.',
    },
    {
      title: 'Quotation Plannig',
      route: '',
      titleFull: 'Quotation Layovers Planning',
      description: 'Assess critical expendable routine requirements for pending quotation projects.',
    },
  ];
}
