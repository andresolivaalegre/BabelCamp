import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EquipoComponent } from './equipo/equipo.component';
import { HistorialComponent } from './historial/historial.component';
import { JugadorComponent } from './jugador/jugador.component';

@NgModule({
  declarations: [
    AppComponent,
    JugadorComponent,
    EquipoComponent,
    HistorialComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
