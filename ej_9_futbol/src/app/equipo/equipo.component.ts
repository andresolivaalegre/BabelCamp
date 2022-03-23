import { Component, OnInit } from '@angular/core';
import { HistorialComponent } from '../historial/historial.component';
import { JugadorComponent } from '../jugador/jugador.component';

@Component({
  selector: 'app-equipo',
  templateUrl: './equipo.component.html',
  styleUrls: ['./equipo.component.css']
})
export class EquipoComponent implements OnInit {

  private _nombre: string;
  private _fundacion: number;
  private _id: string;
  private _jugadores: JugadorComponent[];

  constructor() { 
    this._nombre = ""
    this._fundacion = 0
    this._id = ""
    this._jugadores=[]
  }

  ngOnInit(): void {
  }

  public getId(): string {
    return this._id;
  }
  public setId(value: string) {
    this._id = value;
  }

  public getFundacion(): number {
    return this._fundacion;
  }
  public setFundacion(value: number) {
    this._fundacion = value;
  }
  public getNombre(): string {
    return this._nombre;
  }
  public setNombre(value: string) {
    this._nombre = value;
  }

  public getJugadores(){
      return this._jugadores;

  }

  public anyadirJugador(value: JugadorComponent){
      this._jugadores.push(value);
  }


  public crearyrellenar(){
    this._id="GOAT";
    this._fundacion=1903;
    this._nombre="Atlético de Madrid";

    let j1=new JugadorComponent();
    j1.setNombre("Fernando Torres");
    j1.setEdad(25);
    j1.setPais("España");
    let h1 = new HistorialComponent;
    h1.setId("ABCD");
    h1.setRojas(2);
    h1.setAmarillas(10);
    h1.setGoles(35);
    j1.setHistorial(h1);

    let j2=new JugadorComponent();
    j2.setNombre("Radamel Falcao");
    j2.setEdad(25);
    j2.setPais("Colombia");
    let h2 = new HistorialComponent;
    h2.setId("ABCD");
    h2.setRojas(3);
    h2.setAmarillas(8);
    h2.setGoles(20);
    j2.setHistorial(h2);

    let j3=new JugadorComponent();
    j3.setNombre("Luis Aragones");
    j3.setEdad(25);
    j3.setPais("España");
    let h3 = new HistorialComponent;
    h3.setId("ABCD");
    h3.setRojas(3);
    h3.setAmarillas(8);
    h3.setGoles(20);
    j3.setHistorial(h3);

    let j4=new JugadorComponent();
    j4.setNombre("Luis Aragones");
    j4.setEdad(25);
    j4.setPais("España");

    let j5=new JugadorComponent();
    j5.setNombre("Luis Aragones");
    j5.setEdad(25);
    j5.setPais("España");

    let j6=new JugadorComponent();
    j6.setNombre("Luis Aragones");
    j6.setEdad(25);
    j6.setPais("España");

    let j7=new JugadorComponent();
    j7.setNombre("Luis Aragones");
    j7.setEdad(25);
    j7.setPais("España");

    let j8=new JugadorComponent();
    j8.setNombre("Luis Aragones");
    j8.setEdad(25);
    j8.setPais("España");

    let j9=new JugadorComponent();
    j9.setNombre("Luis Aragones");
    j9.setEdad(25);
    j9.setPais("España");

    let j10=new JugadorComponent();
    j10.setNombre("Luis Aragones");
    j10.setEdad(25);
    j10.setPais("España");
    
    let j11=new JugadorComponent();
    j11.setNombre("Luis Aragones");
    j11.setEdad(25);
    j11.setPais("España");

    this.anyadirJugador(j1);
    this.anyadirJugador(j2);
    this.anyadirJugador(j3);
    this.anyadirJugador(j4);
    this.anyadirJugador(j5);
    this.anyadirJugador(j6);
    this.anyadirJugador(j7);
    this.anyadirJugador(j8);
    this.anyadirJugador(j9);
    this.anyadirJugador(j10);
    this.anyadirJugador(j11);

    }

    
}