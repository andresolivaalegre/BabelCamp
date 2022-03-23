
// Clase que guarda los atributos de un Heroe
export class Juego{


    //Se crean automáticamente los atributos nombre y universo como publicos
    constructor(public id : number, public titulo : string, public compania : string, public valoracion : number){
        this.id = id
        this.titulo = titulo
        this.compania = compania
        this.valoracion = valoracion
    }

    

    public toString() : string {
        return `ID: ${this.id}, Titulo: ${this.titulo}, Compania: ${this.compania}, Valoracion: ${this.valoracion}`
    }

}