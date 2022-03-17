import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-historial',
  templateUrl: './historial.component.html',
  styleUrls: ['./historial.component.css']
})
export class HistorialComponent implements OnInit {

  private _id: string;
  private _goles: number;
  private _amarillas: number;
  private _rojas: number;

  constructor() { 
    this._id = "AA"
    this._goles = 20
    this._amarillas = 20
    this._rojas = 10
  }

  ngOnInit(): void {
  }

  public getId(): string {
    return this._id;
  }
  public setId(value: string) {
    this._id = value;
  }

  public getAmarillas(): number {
    return this._amarillas;
  }
  public setAmarillas(value: number) {
    this._amarillas = value;
  }
  public getRojas(): number {
    return this._rojas;
  }
  public setRojas(value: number) {
    this._rojas = value;
  }
  public getGoles(): number {
        return this._goles;
  }
  public setGoles(value: number) {
        this._goles = value;
  }
}