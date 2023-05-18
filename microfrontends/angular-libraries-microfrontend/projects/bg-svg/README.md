# Angular Background Svg

This library help us to set background image for the component. You can wrap this(as top element) with any component's html element to give background effect to that component or wrap around `<router-outlet></router-outlet>` to get the same background to all the pages.

# Installation

This is how to install the components:

```bash
npm install @ng-ar/bg-svg
```

or 

```bash
yarn add @ng-ar/bg-svg
```

> Minimum angular version needed for this library is v13.0.0.

And on your application module:

```ts
import { HttpClientModule } from '@angular/common/http';
import { BgSvgModule } from '@ng-ar/bg-svg';

@NgModule({
  declarations: [ ...],
  imports: [
    BrowserModule,
    ....,
    HttpClientModule,
    BgSvgModule
],
})
export class AppModule { }
```

- To make this work, your angular app should have `HttpClientModule` included in `AppModule`.

Usage in `html` view as below:

```html
<ng-ar-bg-svg imgPath="assets/images/bg.svg">
  ... top level html element
</ng-ar-bg-svg>
```

```html
<ng-ar-bg-svg imgPath="assets/images/bg.svg">
  <router-outlet></router-outlet>
</ng-ar-bg-svg>
```
or
```html
<ng-ar-bg-svg imgPath="assets/images/bg.svg" [isMinHeightSet]="false">
  <div>
    ...all the html logics for a certain component
  </div>
</ng-ar-bg-svg>
```

- The library receives a prop named `imgPath` that identifies svg image location. This prop is mandatory.
- Apart from this, we have 5 other optional props with boolean values.
- `isRepeat` is for whether to repeat the svg or not. Default value is `false`.
- `isFixed` is to determine whether svg is fixed or not (scrollable). Default value is `true`.
- `isCentre` is to determine whether svg is at centre or not (inherit). Default value is `true`.
- `isFull` is to determine whether svg is covering the whole screen or not (auto). Default value is `true`.
- `isMinHeightSet` is whether to set the view height to 100vh or not. Dafault value is `true`. If you apply `ng-ar-bg-svg ` tag to certain part of html (say header or some div block), I recommend to set this as false, as setting false will take the particular block's space only(not 100% view height).