import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BgSvgComponent } from './bg-svg/bg-svg.component';

@NgModule({
  declarations: [
    BgSvgComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    BgSvgComponent
  ]
})
export class BgSvgModule { }
