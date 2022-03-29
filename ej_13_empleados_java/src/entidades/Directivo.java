package entidades;

import java.util.ArrayList;

public class Directivo extends Empleado{
	
	ArrayList<Empleado> listaEmpleados = new ArrayList<>();
	protected int numEmpleados = 0;

	public ArrayList<Empleado> getEmpleadosCargo() {
		return this.listaEmpleados;
	}

	public void setEmpleadosCargo(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public void anyadirEmpleadoCargo(Empleado empleado) {
		this.listaEmpleados.add(empleado);
		numEmpleados=listaEmpleados.size();
	}
	
	@Override
	public double calcularSueldo() {
		return sueldoBase + numEmpleados*100;
	}
	
	@Override
	public String toString() {
		return "Directivo [Nombre=" + nombre + ", Sueldo Base=" + sueldoBase + ", Numero de Empleados=" + numEmpleados + ", Sueldo Final=" + this.calcularSueldo() + "]";
	}
}
