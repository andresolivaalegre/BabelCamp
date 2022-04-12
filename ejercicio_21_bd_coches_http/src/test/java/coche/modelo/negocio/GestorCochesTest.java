package coche.modelo.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import controlador.ControladorCoches;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import entidad.Coche;
import main.Main;


public class GestorCochesTest {
	
	@Test
	public void GetPorIdTest() {
		
		//Meto id valido y existe
		int id=2;
		GestorCochesTest gc = new GestorCochesTest();
		//Esto es una superchapuza, pero implementé los metodos en el main:( Felix porfa no me mates:( :( :(
		Coche cocheEsperado = new Coche();
		cocheEsperado.setId(2);
		cocheEsperado.setKm(324324);
		cocheEsperado.setMarca("Seat");
		cocheEsperado.setMatricula("4736FTY");
		cocheEsperado.setModelo("Cordoba");
		assertEquals(cocheEsperado, ControladorCoches.buscarId(id));
		
		//Meto id negativo
		id=-15;
		gc = new GestorCochesTest();
		cocheEsperado = new Coche();
		cocheEsperado.setId(0);
		cocheEsperado.setKm(0);
		cocheEsperado.setMarca("");
		cocheEsperado.setMatricula("");
		cocheEsperado.setModelo("");
		assertEquals(cocheEsperado, ControladorCoches.buscarId(id));
		
		//Meto id valido y no existe
		
		id=10;
		gc = new GestorCochesTest();
		cocheEsperado = new Coche();
		cocheEsperado.setId(0);
		cocheEsperado.setKm(0);
		cocheEsperado.setMarca("");
		cocheEsperado.setMatricula("");
		cocheEsperado.setModelo("");
		assertEquals(cocheEsperado, ControladorCoches.buscarId(id));
		
		
	}

}
