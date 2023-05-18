/* eslint-disable @typescript-eslint/no-empty-function */
/* eslint-disable @angular-eslint/no-empty-lifecycle-method */
import { Component, OnInit } from '@angular/core';

import { SvgIconRegistryService } from 'projects/svg-icon/src/public-api';
import { icons as i } from 'projects/input/src/public-api'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  availableIcons = [i.ADDRESS, i.CALENDAR, i.CREDIT_CARD, i.EMAIL, i.EYE_SLASH, i.IMAGE, i.KEY, i.LINK, i.LOCK, i.MONEY,
  i.NIB, i.PENCIL, i.PHONE, i.POST, i.USER, i.WRITING_HAND];

  constructor(private iconRegServ: SvgIconRegistryService) {
    this.availableIcons.forEach(icon => {
      this.iconRegServ.addSvg(icon.icon, icon.svg);
    });
  }

  showMdInput = true;

  pencil = i.PENCIL.icon;


  ngOnInit(): void {
  }

  onFlipInputs() {
    this.showMdInput = !this.showMdInput;
  }

}
