import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

// you can import from npm repo also, if you had it published to npm
import { MdInputModule } from 'projects/md-input/src/public-api';
import { SvgIconModule } from 'projects/svg-icon/src/public-api';
import { InputModule } from 'projects/input/src/public-api';
import { BgSvgModule } from 'projects/bg-svg/src/public-api';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    MdInputModule,
    SvgIconModule.forRoot(),
    InputModule,
    BgSvgModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
