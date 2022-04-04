package entidad.armas;

public class Espada extends Arma{
	
	private int danio=70;
	private String nombre = "espada";
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}


	@Override
	public void usar() {
		System.out.println("Swang!");		
	}
	
	@Override
	public int getDanio() {
		return this.danio;
	}
	
}
