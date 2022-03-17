import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-factorial',
  templateUrl: './factorial.component.html',
  styleUrls: ['./factorial.component.css']
})

export class FactorialComponent implements OnInit{
  
  n:number = 3;

  public calcularFactorial(){
    let suma=this.n;
    let f=this.n;
    while(f>1){
    suma=suma*(f-1);
    f--;}
    return suma;
  }

  ngOnInit() {
  }

}