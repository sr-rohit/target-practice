import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NgxTableviewModule } from './../../projects/ngx-tableview/src/lib/ngx-tableview.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    NgxTableviewModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
