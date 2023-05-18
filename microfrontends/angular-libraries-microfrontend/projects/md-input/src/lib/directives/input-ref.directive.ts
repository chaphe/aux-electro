/* eslint-disable @typescript-eslint/no-empty-function */
import { Directive, HostListener } from '@angular/core';

@Directive({
  selector: 'ng-ar-md-input input'
})
export class InputRefDirective {

  constructor() { }

  focus = false;

  @HostListener('focus')
  onFocus() {
    this.focus = true;
  }

  @HostListener('blur')
  onBlur() {
    this.focus = false;
  }
}