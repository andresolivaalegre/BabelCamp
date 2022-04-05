package entidad.personajes;

import entidad.armas.*;

public class Jefe extends Personaje{
	private String nombre;
	private Arma arma;
	private int vida;
	private int fuerza;
	
	public Jefe(String nombre) {
		this.nombre=nombre;
		this.arma= new PaloCelestial();
		this.vida=2700;
		this.fuerza=(int) (Math.random() * (20 - 10) + 10);

	}
	
	@Override
	public String toString() {
		return "Jefe Final [nombre=" + nombre + ", arma=" + arma.getNombre() + ", vida=" + vida + ", fuerza=" + fuerza + "]";
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
		if(this.arma instanceof PaloCelestial)
			return arma.getDanio()+fuerza;
		return arma.getDanio();
	}
	
	public int atacar() {
		if(!estaMuerto()) {
		System.out.println("AAAAAAAGG!!!");
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
