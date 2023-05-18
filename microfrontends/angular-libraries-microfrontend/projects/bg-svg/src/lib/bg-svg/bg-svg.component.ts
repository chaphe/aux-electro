import { Component, Input, OnInit } from '@angular/core';
import { DomSanitizer, SafeStyle } from '@angular/platform-browser';

import { SvgImage } from '../model/svg-image';

@Component({
  selector: 'ng-ar-bg-svg',
  templateUrl: './bg-svg.component.html',
  styleUrls: ['./bg-svg.component.scss']
})
export class BgSvgComponent implements OnInit {

  backgroundImageStyle!: SafeStyle;
  bgImg = new SvgImage();

  @Input() imgPath!: string;
  @Input() isRepeat = false;
  @Input() isFixed = true;
  @Input() isCentre = true;
  @Input() isFull = true;
  @Input() isMinHeightSet = true;

  constructor(private sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.backgroundImageStyle = this.getBackgroundImage();
    this.getBgImageStyle();
  }


  private getBackgroundImage() {
    // sanitize the style expression
    const style = `background-image: url(${this.imgPath})`;
    return this.sanitizer.bypassSecurityTrustStyle(style);
  }

  private getBgImageStyle() {
    this.isRepeat ? this.bgImg['background-repeat'] = 'repeat' : this.bgImg['background-repeat'] = 'no-repeat';
    this.isFixed ? this.bgImg['background-attachment'] = 'fixed' : this.bgImg['background-attachment'] = 'scroll';
    this.isCentre ? this.bgImg['background-position'] = 'center' : this.bgImg['background-position'] = 'inherit';
    this.isFull ? this.bgImg['background-size'] = 'cover' : this.bgImg['background-size'] = 'auto';
    this.isMinHeightSet ? this.bgImg['min-height'] = '100vh' : this.bgImg['min-height'] = 'auto';
  }
}
