import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-juego',
  templateUrl: './juego.component.html',
  styleUrls: ['./juego.component.css']
})

export class JuegoComponent implements OnInit{
  
  videojuegos: string[] = ['Mario', 'Teken', 'Tetris'];
  aux: string[] = [];

  public eliminarMario(){
    for (let juego of this.videojuegos) {
        if(juego!='Mario')
            this.aux.push(juego);
    }
    return this.aux;
  }


  

  ngOnInit() {
  }

}