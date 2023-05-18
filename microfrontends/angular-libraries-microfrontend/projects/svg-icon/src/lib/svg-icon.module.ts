import { ModuleWithProviders, NgModule, Provider } from '@angular/core';

import { SVG_ICON_REGISTRY_PROVIDER } from './services/svg-icon-registry/svg-icon-registry.service';
import { SvgIconComponent } from './svg-icon/svg-icon.component';
import { SvgHttpLoader, SvgLoader } from './services/svg-loader/svg-loader';

export interface AngularSvgIconConfig {
	loader?: Provider;
}



@NgModule({
  declarations: [
    SvgIconComponent
  ],
  imports: [
  ],
  exports: [
    SvgIconComponent
  ]
})
export class SvgIconModule {
  
	static forRoot(config: AngularSvgIconConfig = {}): ModuleWithProviders<SvgIconModule> {
		return {
			ngModule: SvgIconModule,
			providers: [
				SVG_ICON_REGISTRY_PROVIDER,
				config.loader || { provide: SvgLoader, useClass: SvgHttpLoader }
			]
		};
	}
}
