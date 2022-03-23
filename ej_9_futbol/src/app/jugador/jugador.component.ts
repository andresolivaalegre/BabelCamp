import { Component, OnInit } from '@angular/core';
import { HistorialComponent } from '../historial/historial.component';

@Component({
  selector: 'app-jugador',
  templateUrl: './jugador.component.html',
  styleUrls: ['./jugador.component.css']
})
export class JugadorComponent implements OnInit {

  private _nombre: string;
  private _edad: number;
  private _id: string;
  private _pais: string;
  private _historial: HistorialComponent;

  constructor() { 
    this._nombre = ""
    this._edad = 0
    this._id = ""
    this._pais = ""
    this._historial=new HistorialComponent()
  }

  ngOnInit(): void {
  }

  public getId(): string {
    return this._id;
  }
  public setId(value: string) {
    this._id = value;
  }

  public getEdad(): number {
    return this._edad;
  }
  public setEdad(value: number) {
    this._edad = value;
  }
  public getNombre(): string {
    return this._nombre;
  }
  public setNombre(value: string) {
    this._nombre = value;
  }
  public getPais(): string {
    return this._pais;
  }
  public setPais(value: string) {
    this._pais = value;
  }
  public setHistorial(value: HistorialComponent){
      this._historial=value;
  }
  public getHistorial(){
    return this._historial;
  }
}