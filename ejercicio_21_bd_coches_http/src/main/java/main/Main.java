package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import controlador.ControladorCoches;
import main.*;

import entidad.Coche;
import login.GestorLogin;

public class Main {

	public static void main(String[] args) {
		
		int seleccion = 0;
		int contador=3;
		boolean haEntrado=false;
		while(!haEntrado && contador<0) {
			haEntrado=GestorLogin.validarUsuario();
		}
		GestorLogin.validarUsuario();
		while(seleccion!=11) {
		System.out.println("________________________________________");
		System.out.println("Seleccione la tarea que quiere realizar:");
		System.out.println("1-Alta de un coche");
		System.out.println("2-Eliminar coche por id");
		System.out.println("3-Modificar coche por id");
		System.out.println("4-Buscar coche por id");
		System.out.println("5-Buscar coche por matricula");
		System.out.println("6-Buscar coche por marca");
		System.out.println("7-Buscar coche por modelo");
		System.out.println("8-Listar coches");
		System.out.println("9-Exportar a JSON");
		System.out.println("10-Exportar a PDF");
		System.out.println("11-Salir de la aplicacion");
		System.out.println("________________________________________");
		
		Scanner scan = new Scanner(System.in);
		seleccion=scan.nextInt();
		ControladorCoches c = new ControladorCoches();
		
		if(seleccion==1) {
			c.insertar();
		}
		
		else if(seleccion==2) {
			c.eliminar();
		}
		else if(seleccion==3) {
			c.modificar();
		}
		else if(seleccion==4) {
			c.buscarId();
		}
		else if(seleccion==5) {
			c.buscarMatricula();
		}
		else if(seleccion==6) {
			c.buscarMarca();
		}
		else if(seleccion==7) {
			c.buscarModelo();
		}
		else if(seleccion==8) {
			c.listarCoches();
		}
		else if(seleccion==9) {
			c.exportarJson();
		}
		else if(seleccion==10) {
			c.exportarPdf();
		}
	}
		
		System.out.println("¡Gracias por usar mi aplicacion!");
		
		
	}

}




