import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { SvgIconModule } from '@ng-ar/svg-icon';

import { InputComponent } from './input/input.component';
import { InputRefDirective } from './directives/input-ref.directive';



@NgModule({
  declarations: [
    InputComponent,
    InputRefDirective
  ],
  imports: [
    HttpClientModule,
    CommonModule,
    BrowserModule,
    SvgIconModule.forRoot()
  ],
  exports: [
    InputComponent,
    InputRefDirective
  ]
})
export class InputModule { }
