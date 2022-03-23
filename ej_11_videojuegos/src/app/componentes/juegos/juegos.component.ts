import { Component, OnInit } from '@angular/core';
import { Juego } from 'src/app/entidades/juego';


@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.component.html',
  styleUrls: ['./juegos.component.css']
})
export class JuegosComponent implements OnInit {

  listaJuegos : Juego[] = []
  juego : Juego | null = null


  id : number = 0
  titulo : string = ""
  compania : string = ""
  valoracion : number = 0

  constructor() { 
    let juego : Juego = new Juego(0, "Elden Ring", "JuegosJuegos", 5)
    this.listaJuegos.push(juego);
    juego = new Juego(1, "Fortnite", "Supercell", 3)
    this.listaJuegos.push(juego)
  }

  public insertar(){
    
      this.juego = new Juego(this.id, this.titulo, this.compania, this.valoracion)
      this.listaJuegos.push(this.juego)
      this.vaciar()
  }




  

 
  public vaciar(){  
    this.id = 0
    this.titulo = ""
    this.compania = ""
    this.valoracion = 0
  }
  
 
  
  ngOnInit() {

  }

}
