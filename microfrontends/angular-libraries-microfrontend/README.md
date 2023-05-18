# AngularLibDemo

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 13.1.0. 

### Libraries in this repo

Code for the library(ies) of [@ng-ar/md-input](https://www.npmjs.com/package/@ng-ar/md-input), [@ng-ar/svg-icon](https://www.npmjs.com/package/@ng-ar/svg-icon), [@ng-ar/input](https://www.npmjs.com/package/@ng-ar/input) and [@ng-ar/bg-svg](https://www.npmjs.com/package/@ng-ar/bg-svg) is(are) included in this repo.

## Creating angular workspace without angular app

```bash
$ ng new my-workspace --no-create-application
$ cd my-workspace
$ ng generate library my-lib
```

> we can create libraries with angular app also

```bash
$ cd my-workspace
$ ng generate library my-lib --prefix demo 
```

```bash
ng g lib my-lib --prefix demo
```

> This adds a `projects` directory containing a `my-lib` directory(library folder) for our newly generated `my-workspace` Angular workspace.

```bash
ng generate application my-app
```

> This adds a `my-app` directory(application folder) in the `projects` directory

### Generating component, directives, etc. to lib and app

```bash
ng g d <directive-name> --project=<project-name>
```

one example

```bash
ng g d directives/input-ref --project=md-input --dry-run
```

`--dry-run` flag won't generate anything, but will show in console. 

### testing library in dev

```bash
$ ng build my-lib --configuration development
$ ng test my-lib
$ ng lint my-lib
```

### Building library

```bash
ng build my-lib
```

### Serving our appliaction

```bash
ng serve my-app
```

### Publishing your library

```bash
$ ng build my-lib
$ cd dist/my-lib
$ npm publish
```

Whwn publishing first time to the public repo of npm, please use the below command.

```bash
npm publish --access public
```

### Managing assets in a library

When including additional assets like Sass mixins or pre-compiled CSS. You need to add these manually to the conditional `exports` in the package.json of the primary entrypoint.

[ng-packagr](https://www.npmjs.com/package/ng-packagr) will merge handwritten `exports` with the auto-generated ones, allowing for library authors to configure additional export subpaths, or custom conditions.

```json
"exports": {
  ".": {
    "sass": "./_index.scss",
  },
  "./theming": {
    "sass": "./_theming.scss"
  },
  "./prebuilt-themes/indigo-pink.css": {
    "style": "./prebuilt-themes/indigo-pink.css"
  }
}
```

### Building and rebuilding your library

```bash
ng build my-lib --watch
```

### Linking already built with watch mode to Angular app

```bash
$ cd dist/my-lib
$ npm link
```

Now open the seperate angular app where you want to test it

```bash
npm link my-lib
```

If you already have `my-lib` it installed through npm

```bash
npm uninstall my-lib
```

add the following to the root `package.json` file

```json
"scripts": {
  ...
  "build_lib": "ng build my-lib",
  "npm_pack": "cd dist/my-lib && npm pack",
  "package": "npm run build_lib && npm run npm_pack"
},
```

```
npm install ../angular-lib-demo/dist/my-lib/my-lib-0.0.1.tgz
```

```typescript
import { AngularLibDemoModule } from 'my-lib';
```

## Deploy to GitHub Pages

1. To begin, add the `angular-cli-ghpages` builder.

```bash
ng add angular-cli-ghpages
```

2. If you’re deploying the project to a Github project page you’ll need to set the `baseHref` property as the repository name. The `baseHref` will be used for all relative URLs on your site. You could specify the `baseHref` as part of the project architect deploy options in the `angular.json` file. Or just pass it as the `--base-href` flag to the `ng deploy` command. If you’re deploying the project to a Github user page, you do not need to set this option.

```bash
ng deploy --base-href=/<repository-name>/
```

GitHub will automatically enable Pages when you push a gh-pages branch. There is no need to enable Pages from the repository settings.

```bash
ng deploy --base-href=/angular-lib-demo/
```

### Support Docs

- [Creating libraries - Official](https://angular.io/guide/creating-libraries)
- [The Angular Library Series - Creating a Library with Angular CLI](https://medium.com/angular-in-depth/creating-a-library-in-angular-6-87799552e7e5)
- [Create your Angular Library and linking](https://medium.com/@prajramesh93/create-your-angular-library-f2cf273fd8a5)
- [Material Icons' Symbols](https://fonts.google.com/icons)
- [Material Icons Guide](https://developers.google.com/fonts/docs/material_icons)
- ['angular-svg-icon' repo](https://github.com/czeckd/angular-svg-icon)
- [Angular: Using custom made SVG icons through Angular Material](https://dev.to/elasticrash/using-custom-made-svg-icons-through-the-angular-material-library-2pif)
- [Material Icon - custom icons](https://material.angular.io/components/icon/examples)
- [Free Svg Repo](https://www.svgrepo.com/)
- [Hex Color To CSS Filter Converter](https://isotropic.co/tool/hex-color-to-css-filter/)
- [Free svg background - heazy](https://app.heazy.studio/)
- [Free svg background - haikei](https://app.haikei.app/)
