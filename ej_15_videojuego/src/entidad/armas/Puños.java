package entidad.armas;

public class Pu�os extends Arma{
	
	private int danio=20;
	private String nombre = "pu�os";

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
		System.out.println("Pammmm!");		
	}
	
	@Override
	public int getDanio() {
		return this.danio;
	}
	
	
}
