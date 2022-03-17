import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { NotaComponent } from './nota/nota.component';
import { JuegoComponent } from './juego/juego.component';
import { FactorialComponent } from './factorial/factorial.component';

@NgModule({
  declarations: [
    AppComponent,
      NotaComponent,
      JuegoComponent,
      FactorialComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
