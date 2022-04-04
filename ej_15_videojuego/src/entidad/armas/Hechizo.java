package entidad.armas;

public class Hechizo extends Arma{
	
	private int danio=80;
    private String nombre = "hechizo";
	
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
		System.out.println("Tocoto!");		
	}
	
	@Override
	public int getDanio() {
		return this.danio;
	}
	
	
}
