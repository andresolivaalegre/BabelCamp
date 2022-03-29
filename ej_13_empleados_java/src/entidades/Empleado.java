package entidades;

public abstract class Empleado {
	
	protected String nombre;
	protected int sueldoBase;
	
	public abstract double calcularSueldo();
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSueldoBase() {
		return this.sueldoBase;
	}
	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

}
