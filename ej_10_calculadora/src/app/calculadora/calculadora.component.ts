import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css']
})

export class CalculadoraComponent implements OnInit{

    resultado : number = 0
    n1 : number = 2
    n2 : number = 2


    public suma(){
        this.resultado = Number(this.n1)+Number(this.n2)
        
    }

    public resta(){
        this.resultado = this.n1-this.n2
    }

    public multiplicacion(){
        this.resultado = this.n1*this.n2
    }

    public division(){
        this.resultado = this.n1/this.n2
    }
    
    
    


    ngOnInit(): void {
    }
  
}