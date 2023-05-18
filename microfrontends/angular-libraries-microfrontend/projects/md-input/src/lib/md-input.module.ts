import { NgModule } from '@angular/core';

import { MdInputComponent } from './md-input/md-input.component';
import { InputRefDirective } from './directives/input-ref.directive';



@NgModule({
  declarations: [
    MdInputComponent,
    InputRefDirective
  ],
  imports: [
  ],
  exports: [
    MdInputComponent,
    InputRefDirective
  ]
})
export class MdInputModule { }
