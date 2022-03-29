package main;

import java.util.ArrayList;

import entidades.*;

public class Main {
	public static void main(String[] args) {
		
		//Creamos los trabajadores
		Trabajador t1=new Trabajador();
		t1.setNombre("Jose Malo");
		t1.setSueldoBase(1000);
		t1.setValoracion(2);
		Trabajador t2=new Trabajador();
		t2.setNombre("Pedro Medio");
		t2.setSueldoBase(1000);
		t2.setValoracion(6);
		Trabajador t3=new Trabajador();
		t3.setNombre("Azucena Buena");
		t3.setSueldoBase(1000);
		t3.setValoracion(10);
		
		//Creamos los jefes
		Jefe j1=new Jefe();
		j1.setNombre("Daniela Hereda");
		j1.setSueldoBase(2000);
		j1.setIncentivos(250);
		Jefe j2=new Jefe();
		j2.setNombre("Daniel Mandon");
		j2.setSueldoBase(2000);
		j2.setIncentivos(350);
		
		//Creamos los directivos
		Directivo d1=new Directivo();
		d1.setNombre("Luis Adinerado");
		d1.setSueldoBase(7000);
		d1.anyadirEmpleadoCargo(t1);
		d1.anyadirEmpleadoCargo(t2);
		d1.anyadirEmpleadoCargo(t3);
		d1.anyadirEmpleadoCargo(j1);
		d1.anyadirEmpleadoCargo(j1);
		
		//Creamos y añadimos todos al arraylist
		ArrayList<Empleado> lista = new ArrayList<>();
		lista.add(t1);
		lista.add(t2);
		lista.add(t3);
		lista.add(j1);
		lista.add(j2);
		lista.add(d1);
		
		System.out.println("----------------Empleados----------------");
		for(Empleado empleado : lista){
			System.out.println(empleado.toString());
		}
		System.out.println("-----------------------------------------");
	}
}
