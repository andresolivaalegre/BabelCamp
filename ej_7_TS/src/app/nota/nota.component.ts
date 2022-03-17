import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nota',
  templateUrl: './nota.component.html',
  styleUrls: ['./nota.component.css']
})

export class NotaComponent implements OnInit{
  e1 : number = 4
  e2 : number = 8.5
  e3 : number = 5
  ef : number = 8
  t : number = 9.75
  nota: number = ((this.e1+this.e2+this.e3)/3)*0.55+this.ef*0.3+this.t*0.15


  ngOnInit() {
  }

}
