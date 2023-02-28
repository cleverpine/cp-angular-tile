import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { TileComponent } from './tile.component';



@NgModule({
  declarations: [
    TileComponent
  ],
  imports: [
    RouterModule
  ],
  exports: [
    TileComponent
  ]
})
export class TileModule { }
