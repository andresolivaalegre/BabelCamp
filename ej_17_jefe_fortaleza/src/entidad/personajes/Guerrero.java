package entidad.personajes;

import entidad.armas.*;

public class Guerrero extends Personaje{
	private String nombre;
	private Arma arma;
	private int vida;
	private int fuerza;
	
	public Guerrero(String nombre) {
		this.nombre=nombre;
		this.arma= new Puños();
		this.vida=2000;
		this.fuerza=40;

	}
	
	@Override
	public String toString() {
		return "Guerrero [nombre=" + nombre + ", arma=" + arma.getNombre() + ", vida=" + vida + ", fuerza=" + fuerza + "]";
	}

	
	public boolean estaMuerto() {
		if(this.vida<=0) {
			return true;
		}
		return false;
	}
	
	public void recibirDanio(int danio){
		this.vida-=danio;
		estaMuerto();
	}
	
	public int calcularDanio() {
		if(estaMuerto())
			return 0;
		if(this.arma instanceof Arco || this.arma instanceof Espada)
			return arma.getDanio()+fuerza;
		return arma.getDanio();
	}
	
	public int atacar() {
		if(!estaMuerto()) {
		System.out.println("Argggg!!!");
		System.out.println("Soy " + this.nombre + " y te dare una paliza con mi " + arma.getNombre());
		arma.usar();
		}
		return calcularDanio();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArma() {
		return arma;
	}

	public void cogerArma(Arma arma) {
		this.arma = arma;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}



}
