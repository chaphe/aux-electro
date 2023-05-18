/* eslint-disable @typescript-eslint/no-empty-function */
/* eslint-disable @angular-eslint/no-empty-lifecycle-method */
import { AfterContentInit, Component, ContentChild, HostBinding, Input, OnInit } from '@angular/core';

import { InputRefDirective } from '../directives/input-ref.directive';

@Component({
  selector: 'ng-ar-md-input',
  templateUrl: './md-input.component.html',
  styleUrls: ['./md-input.component.scss']
})
export class MdInputComponent implements OnInit, AfterContentInit {
  @Input() icon  = 'edit';
  @ContentChild(InputRefDirective) inputEl!: InputRefDirective;
  
  constructor() {}

  ngOnInit(): void {}

  ngAfterContentInit(): void {
    if (!this.inputEl) {
      console.error('"ng-ar-md-input" needed an "input" element inside.');
    }
  }

  @HostBinding('class.input-focus')
  get isInputFocus() {
    return this.inputEl ? this.inputEl.focus : false;
  }
}
