package entidad.armas;

public class PaloCelestial extends Arma{
	
	private int danio=(int) (Math.random() * (100 - 50) + 30);
    private String nombre = "palo celestial";
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void usar() {
		System.out.println("TOC TOC");
	}
	
	@Override
	public int getDanio() {
		return this.danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}
	
}
