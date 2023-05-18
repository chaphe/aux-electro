/* eslint-disable @angular-eslint/component-selector */
/* eslint-disable @typescript-eslint/no-empty-function */
/* eslint-disable @angular-eslint/no-empty-lifecycle-method */
import { Component, ContentChild, HostBinding, Input, OnInit } from '@angular/core';

import { SvgIconRegistryService } from '@ng-ar/svg-icon';

import { InputRefDirective } from '../directives/input-ref.directive';
import * as i from '../shared/svg-files';

const SVG_ICONS = [
  i.ADDRESS, i.CALENDAR, i.CREDIT_CARD, i.EMAIL, i.EYE_SLASH, i.IMAGE, i.KEY, i.LINK, i.LOCK, i.MONEY, i.NIB,
  i.PENCIL, i.PHONE, i.POST, i.USER, i.WRITING_HAND
];

@Component({
  selector: 'ng-ar-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.scss']
})
export class InputComponent implements OnInit {
  @Input() icon: string  = i.WRITING_HAND.icon;
  @Input() src!: string;
  @Input() isSrcUrl: boolean = false;
  @Input() isIconColorChange: boolean = true;
 
  @ContentChild(InputRefDirective) inputEl!: InputRefDirective;

  constructor(private iconRegServ: SvgIconRegistryService) {
    SVG_ICONS.forEach(icon => {
      this.iconRegServ.addSvg(icon.icon, icon.svg);
    });
  }

  ngOnInit(): void {}

  ngAfterContentInit(): void {
    // console.log(this.inputEl);
    if (!this.inputEl) {
      console.error('"ng-ar-input" needed an "input" element inside.');
    }
  }

  @HostBinding('class.input-focus')
  get isInputFocus() {
    return this.inputEl ? this.inputEl.focus : false;
  }

}