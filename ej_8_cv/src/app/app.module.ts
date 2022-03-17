import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IzdaComponent } from './izda/izda.component';
import { DchaComponent } from './dcha/dcha.component';


@NgModule({
  declarations: [
    AppComponent,
    IzdaComponent, 
    DchaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
