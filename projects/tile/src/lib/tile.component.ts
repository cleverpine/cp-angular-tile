import { Component, Input } from '@angular/core';

@Component({
  selector: 'lht-tile',
  templateUrl: './tile.component.html',
  styleUrls: ['./tile.component.scss'],
})
export class TileComponent {

  @Input() href!: string;

}
