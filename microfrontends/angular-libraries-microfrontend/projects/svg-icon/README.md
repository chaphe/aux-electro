# Angular SVG Icon

The `@ng-ar/svg-icon` is an Angular 13 service and component that provides a means to inline SVG files to allow for them to be easily styled by CSS and code.

The service provides an icon registery that loads and caches a SVG indexed by its url. The component is responsible for displaying the SVG. After getting the svg from the registry it clones the `SVGElement` and the SVG to the component's inner HTML.

# Installation

This is how to install the components:

```bash
npm install @ng-ar/svg-icon
```

or 

```bash
yarn add @ng-ar/svg-icon
```

> Minimum angular version needed for this library is v13.0.0.

And on your application module:

```ts
import { HttpClientModule } from '@angular/common/http';
import { SvgIconModule } from '@ng-ar/svg-icon';

@NgModule({
  declarations: [ ...],
  imports: [
    BrowserModule,
    HttpClientModule,
    ....,
    SvgIconModule.forRoot()
],
})
export class AppModule { }
```

- To make this work, your angular app should have `HttpClientModule` included in `AppModule`.
- Recommened usage pattern is to import `SvgIconModule.forRoot()` in only the root AppModule of your application In child modules, import only `SvgIconModule`.

## Usage
Basic way of using is as below:

```html
  <ng-ar-svg-icon src="../assets/images/mail.svg" [svgStyle]="{ 'width.px':24, 'height.px': 24 }">
  </ng-ar-svg-icon>
```
*Note that without a height or width set, the SVG may not display!*

If svg was previously loaded via registry with name, it can be used like this:

```html
  <ng-ar-svg-icon name="mail" [svgStyle]="{ 'width.px':24, 'height.px': 24 }">
  </ng-ar-svg-icon>
```

More complex styling can be applied to the svg, for example:

```html
<ng-ar-svg-icon src="assets/images/mail.svg" [stretch]="true"
  [svgStyle]="{'width.px':170,'fill':'rgb(150,50,255)','padding.px':1,'margin.px':3}">
</ng-ar-svg-icon>
```

The following attributes can be set on svg-icon:
- **src** - The path to SVG.
- **name** - An optional name of SVG, under which it was loaded via SvgIconRegistryService.
- **[svgStyle]** - Optional styles to be applied to the SVG, this is based on the familiar [ngStyle].
- **[stretch]** - An optional boolean (default is false) that when true, sets `preserveAspectRatio="none"` on the SVG. This is useful for setting both the height and width styles to strech *or* distort the svg.
- **[class]** - An optional string of the class or classes to apply to the SVG (duplicates what is set on the `svg-icon`).
- **[applyClass]** - An optional boolean (default is false) that copies the `class` attribute on the `svg-icon` and adds it to the SVG.
- **[svgClass]** - An optional string of the class or classes to apply to the SVG (independent of what is set for the class on the `svg-icon`).
- **[viewBox]** - An optional string to set the viewBox on the SVG. If the `viewBox="auto"`, then `svg-icon` will attempt to convert the SVG's width and height attributes to a `viewBox="0 0 w h"`. Both explicitly setting the viewBox or `auto` setting the viewBox will remove the SVG's width and height attributes.
- **[svgAriaLabel]** - An optional string to set the SVG's `aria-label`. If the SVG does not have a pre-existing `aria-label` and the `svgAriaLabel` is not set, then the SVG will be loaded with `aria-hidden=true`. If the SVG has an `aria-label`, then the SVG's default will be used. To remove the SVG's `aria-label`, assign an empty string `''` to `svgAriaLabel`. Doing so will remove any existing `aria-label` and set `aria-hidden=true` on the SVG.

### Using the Svg-Icon Registry

Programatic interaction with the registry is also possible.

Include the `private iconReg: SvgIconRegistryService` in the constructor:

```ts
constructor(private iconReg:SvgIconRegistryService) { }
```

- The registry has three public API methods: `loadSvg(string)`, `addSvg(string, string)`, and `unloadSvg(string)`.

To preload a SVG file from a URL into the registry:
```ts
{
  ...
  this.iconReg.loadSvg('eye.svg').subscribe();
}
```
To preload a SVG file from a URL into the registry with predefined name:
```ts
{
  ...
  this.iconReg.loadSvg('eye.svg', 'my-eye').subscribe();
}
```
To add a SVG from a string:
```ts
{
  ...
  this.iconReg.addSvg('eye',
   '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10 10"><path d="M1 1 L1 9 L9 9 L9 1 Z"/></svg>'
  );
}
```
To unload a SVG from the registry.
```typescript
{
  ...
  this.iconReg.unloadSvg('eye.svg');
}
```

## Usage with Angular Universal

When rendering on server-side, the SVGs must be loaded via the file system.
This can be achieved by providing an `SvgLoader` to the server module:

```typescript
export function svgLoaderFactory(http: HttpClient, transferState: TransferState) {
  return new SvgServerLoader('browser/assets/icons', transferState);
}

@NgModule({
  imports: [
    SvgIconModule.forRoot({
      loader: {
        provide: SvgLoader,
        useFactory: svgLoaderFactory,
        deps: [ HttpClient, TransferState ],
      }
    }),
    AppModule,
    ServerModule,
    ServerTransferStateModule,
    ModuleMapLoaderModule,
  ],
  bootstrap: [ AppComponent ],
})
export class AppServerModule {
}
```

The loader itself is up to you to implement because it depends on where your
icons are stored locally. An implementation that additionally saves the icons
in the transfer state of your app in order to avoid double requests could look
like that:

```typescript
const fs = require('fs');
const join = require('path').join;
const parseUrl = require('url').parse;
const baseName = require('path').basename;

export class SvgServerLoader implements SvgLoader {

  constructor(private iconPath: string,
    private transferState: TransferState) {
  }

  getSvg(url: string): Observable<string> {
    const parsedUrl:URL = parseUrl(url);
    const fileNameWithHash = baseName(parsedUrl.pathname);
    // Remove content hashing
    const fileName = fileNameWithHash.replace(/^(.*)(\.[0-9a-f]{16,})(\.svg)$/i, '$1$3');
    const filePath = join(this.iconPath, fileName);
    return Observable.create(observer => {
      const svgData = fs.readFileSync(filePath, 'utf8');

      // Here we save the translations in the transfer-state
      const key: StateKey<number> = makeStateKey<number>('transfer-svg:' + url);
      this.transferState.set(key, svgData);

      observer.next(svgData);
      observer.complete();
    });
  }
}
```

Note that this is executed in a local Node.js context, so the Node.js API is 
available.

A loader for the client module that firstly checks the transfer state could
look like that:

```typescript
export class SvgBrowserLoader implements SvgLoader {
  constructor(private transferState: TransferState,
    private http: HttpClient) {
  }
  getSvg(url: string): Observable<string> {
    const key: StateKey<number> = makeStateKey<number>('transfer-svg:' + url);
    const data = this.transferState.get(key, null);
    // First we are looking for the translations in transfer-state, if none found, http load as fallback
    if (data) {
      return Observable.create(observer => {
        observer.next(data);
        observer.complete();
      });
    } else {
      return new SvgHttpLoader(this.http).getSvg(url);
    }
  }
}
```

This is executed on browser side. Note that the fallback when no data is
available uses `SvgHttpLoader`, which is also the default loader if you don't
provide one.

## Example Project with Angular Universal and `@ng-ar/svg-icon`

The basic steps to get it work is:

1. Add this snippet to the `package.json` file to prevent compilation issues:
```js
    "browser": {
      "fs": false,
      "path": false,
      "os": false
    }
```
2. Add `ServerTransferStateModule` to `app.server.module`
3. Add `BrowserTransferStateModule` to `app.module`
4. The loader should be different per platform, so the factory should receive the `PLATFORM_ID` and load the correct class appropriately (this is already added in the example).

## SVG Preparation
The SVG should be modified to remove the height and width attributes from the file
per Sara Soueidan's advice in "[Making SVGs Responsive With
CSS](http://tympanus.net/codrops/2014/08/19/making-svgs-responsive-with-css/)" if
size is to be modified through CSS. Removing the height and width has two immedate
impacts: (1) CSS can be used to size the SVG, and (2) CSS will be *required* to 
size the SVG.