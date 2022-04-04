package entidad.personajes;
import entidad.armas.*;


public class Mago extends Personaje{
	private String nombre;
	private Arma arma;
	private int vida;
	private int inteligencia;
	
	public Mago(String nombre) {
		this.nombre=nombre;
		this.arma= new Puños();
		this.vida=1500;
		this.inteligencia=55;
	}
	
	@Override
	public String toString() {
		return "Mago [nombre=" + nombre + ", arma=" + arma.getNombre() + ", vida=" + vida + ", inteligencia=" + inteligencia + "]";
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
		if(this.arma instanceof Hechizo)
			return arma.getDanio()+inteligencia;
		return arma.getDanio();
	}
	
	public int atacar() {
		if(!estaMuerto()) {
		System.out.println("Abra kadabra!!!");
		System.out.println("Soy " + this.nombre + " y te enseñare mis trucos en forma de " + arma.getNombre());
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

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	

}