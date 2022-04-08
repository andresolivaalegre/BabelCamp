package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

import com.google.gson.Gson;

import main.*;

import entidad.Coche;

public class Main {

	public static void main(String[] args) {
		
		int seleccion = 0;
		Coche coche = new Coche();
		
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
		
		if(seleccion==1) {
			insertar();
		}
		
		else if(seleccion==2) {
			eliminar();
		}
		else if(seleccion==3) {
			modificar();
		}
		else if(seleccion==4) {
			buscarId();
		}
		else if(seleccion==5) {
			buscarMatricula();
		}
		else if(seleccion==6) {
			buscarMarca();
		}
		else if(seleccion==7) {
			buscarModelo();
		}
		else if(seleccion==8) {
			listarCoches();
		}
		else if(seleccion==9) {
			exportarJson();
		}
		else if(seleccion==10) {
			exportarPdf();
		}
	}
		
		System.out.println("¡Gracias por usar mi aplicacion!");
		
		
	}


	
	
	public static void insertar() {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coches";
		String user = "root";
		String pass = "";
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			
			//Creamos el coche que contendrá los datos
			Coche coche = new Coche(); 
			coche.setMatricula("0000AA");
			coche.setKm(-1);
			//La consulta ejecutada:
			String sql = "INSERT INTO COCHE (ID, MATRICULA, MARCA, MODELO, KM) VALUES (?, ?, ?, ?, ?)"; 
			//El scanner:
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Ha elegido anyadir un coche");
			//Recogemos los datos del coche
			System.out.println("Introduzca un id valido");
			coche.setId(scan.nextInt());
			while(coche.getMatricula().length()!=7) { //Filtramos matriculas
			System.out.println("Introduzca una matricula valida");
			coche.setMatricula(scan.next());
			}
			System.out.println("Introduzca la marca");
			coche.setMarca(scan.next());
			System.out.println("Introduzca el modelo");
			coche.setModelo(scan.next());
			while(coche.getKm()<0) {
			System.out.println("Introduzca un numero valido de km"); //Filtramos km
			coche.setKm(scan.nextInt());
			}
			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);
			
			PreparedStatement sentencia;
			sentencia = con.prepareStatement(sql);
			sentencia.setInt(1, coche.getId());
			sentencia.setString(2, coche.getMatricula());//
			sentencia.setString(3, coche.getMarca());//
			sentencia.setString(4, coche.getModelo());
			sentencia.setInt(5, coche.getKm());
			
			int afectados = sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("Registros afectados: "+afectados);
		} catch (SQLException e) {
			System.out.println("Error al añadir una nueva persona");
			System.out.println(e.getMessage());
		}
	}
	
	public static Coche buscarId() {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coches";
		String user = "root";
		String pass = "";
		
		
		
		// Paso 2: Interactuar con la BD 
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			
			Coche coche = new Coche();
			coche.setId(0);
			coche.setKm(0);
			coche.setMarca("");
			coche.setMatricula("");
			coche.setModelo("");
			//Scanner
			Scanner scan = new Scanner(System.in);
			System.out.println("Introduzca un id valido");
			int id= scan.nextInt();
			
			//Preparamos la sentencia
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COCHE WHERE ID=?");
			sentencia.setInt(1,id);
			ResultSet rs = sentencia.executeQuery();
			
			
			//Mostramos la coincidencia
			while (rs.next()) {
				System.out.print("ID:" + rs.getInt("ID"));
				System.out.print(" - "); 
				System.out.print("MATRICULA:" +rs.getString("MATRICULA"));
				System.out.print(" - "); 
				System.out.print("MARCA:" +rs.getString("MARCA"));
				System.out.print(" - "); 
				System.out.print("MODELO:" +rs.getString("MODELO"));
				System.out.print(" - "); 
				System.out.print("KM:" +rs.getInt("KM"));
				System.out.println(); 
				coche.setId(rs.getInt("ID"));
				coche.setKm(rs.getInt("KM"));
				coche.setMarca(rs.getString("MARCA"));
				coche.setMatricula(rs.getString("MATRICULA"));
				coche.setModelo(rs.getString("MODELO"));
				return coche;
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}		
		return null;
		
	}

	public static void buscarMatricula() {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coches";
		String user = "root";
		String pass = "";
		
		
		
		// Paso 2: Interactuar con la BD 
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			
			//Scanner
			Scanner scan = new Scanner(System.in);
			System.out.println("Introduzca una matricula valida");
			String matricula= scan.next();
			
			//Preparamos la sentencia
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COCHE WHERE MATRICULA=?");
			sentencia.setString(1,matricula);
			ResultSet rs = sentencia.executeQuery();
			
			
			//Mostramos la coincidencia
			while (rs.next()) {
				System.out.print("ID:" + rs.getInt("ID"));
				System.out.print(" - "); 
				System.out.print("MATRICULA:" +rs.getString("MATRICULA"));
				System.out.print(" - "); 
				System.out.print("MARCA:" +rs.getString("MARCA"));
				System.out.print(" - "); 
				System.out.print("MODELO:" +rs.getString("MODELO"));
				System.out.print(" - "); 
				System.out.print("KM:" +rs.getInt("KM"));
				System.out.println(); 
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}		
	}


	public static void buscarMarca() {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coches";
		String user = "root";
		String pass = "";
		
		
		// Paso 2: Interactuar con la BD 
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			
			//Scanner
			Scanner scan = new Scanner(System.in);
			System.out.println("Introduzca una marca");
			String marca= scan.next();
			
			//Preparamos la sentencia
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COCHE WHERE MARCA=?");
			sentencia.setString(1,marca);
			ResultSet rs = sentencia.executeQuery();
			
			
			//Mostramos la coincidencia
			while (rs.next()) {
				System.out.print("ID:" + rs.getInt("ID"));
				System.out.print(" - "); 
				System.out.print("MATRICULA:" +rs.getString("MATRICULA"));
				System.out.print(" - "); 
				System.out.print("MARCA:" +rs.getString("MARCA"));
				System.out.print(" - "); 
				System.out.print("MODELO:" +rs.getString("MODELO"));
				System.out.print(" - "); 
				System.out.print("KM:" +rs.getInt("KM"));
				System.out.println(); 
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}	
	
	}

	public static void buscarModelo() {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coches";
		String user = "root";
		String pass = "";
		
		
		// Paso 2: Interactuar con la BD 
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			
			//Scanner
			Scanner scan = new Scanner(System.in);
			System.out.println("Introduzca una marca");
			String modelo= scan.next();
			
			//Preparamos la sentencia
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COCHE WHERE MODELO=?");
			sentencia.setString(1,modelo);
			ResultSet rs = sentencia.executeQuery();
			
			
			//Mostramos la coincidencia
			while (rs.next()) {
				System.out.print("ID:" + rs.getInt("ID"));
				System.out.print(" - "); 
				System.out.print("MATRICULA:" +rs.getString("MATRICULA"));
				System.out.print(" - "); 
				System.out.print("MARCA:" +rs.getString("MARCA"));
				System.out.print(" - "); 
				System.out.print("MODELO:" +rs.getString("MODELO"));
				System.out.print(" - "); 
				System.out.print("KM:" +rs.getInt("KM"));
				System.out.println(); 
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}	
	
	}
	
	public static void modificar() {
		
		// Paso 1: Establecemos los parametros de conexión con la base de datos
				String cadenaConexion = "jdbc:mysql://localhost:3306/coches";
				String user = "root";
				String pass = "";
				Coche coche = new Coche();
				coche.setMatricula("0000AA");
				coche.setKm(-1);
					
				// Paso 2: Interactuar con la BD 
				try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
					
					
					//Scanner
					Scanner scan = new Scanner(System.in);
					
					System.out.println("Introduzca el id del coche que quiere modificar");
					coche.setId(scan.nextInt());
					
					while(coche.getMatricula().length()!=7) { //Filtramos matriculas
					System.out.println("Introduzca una matricula valida");
					coche.setMatricula(scan.next());
					}
					
					System.out.println("Introduzca la marca");
					coche.setMarca(scan.next());
					
					System.out.println("Introduzca el modelo");
					coche.setModelo(scan.next());
					
					while(coche.getKm()<0) {
					System.out.println("Introduzca un numero valido de km"); //Filtramos km
					coche.setKm(scan.nextInt());
					}
					
					String sql = "update coche set MATRICULA=?, MARCA=?, MODELO=?, KM=? WHERE ID=?";
					System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
					System.out.println(sql);
					
					PreparedStatement sentencia = con.prepareStatement(sql);
					
					
					sentencia.setString(1, coche.getMatricula());
					sentencia.setString(2, coche.getMarca());
					sentencia.setString(3, coche.getModelo());
					sentencia.setInt(4, coche.getKm());
					sentencia.setInt(5, coche.getId());
					
					//como estamos cambiando datos de la BBDD, hacemos un executeUpdate
					int afectados = sentencia.executeUpdate();
					System.out.println("Sentencia SQL ejecutada con éxito");
					System.out.println("Registros afectados: "+afectados);
				} catch (SQLException e) {
					System.out.println("Error al añadir nuevo cliente");
					System.out.println(e.getMessage());
				}		
		
	}

	public static void listarCoches() {
		
				String cadenaConexion = "jdbc:mysql://localhost:3306/coches";
				String user = "root";
				String pass = "";
				
	
				try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
					PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COCHE");
					ResultSet rs = sentencia.executeQuery();//no cambia registros, se usa para consultas
					while (rs.next()) {//preguntamos si hay mas filas
						System.out.print("ID:" + rs.getInt("ID"));
						System.out.print(" - "); 
						System.out.print("MATRICULA:" +rs.getString("MATRICULA"));
						System.out.print(" - "); 
						System.out.print("MARCA:" +rs.getString("MARCA"));
						System.out.print(" - "); 
						System.out.print("MODELO:" +rs.getString("MODELO"));
						System.out.print(" - "); 
						System.out.print("KM:" +rs.getInt("KM"));
						System.out.println(); 
					}
				} catch (SQLException e) {
					System.out.println("Error al realizar el listado de productos");
					System.out.println(e.getMessage());
				}		
	
	}
	
	public static void eliminar() {
		
		// Paso 1: Establecemos los parametros de conexión con la base de datos
				String cadenaConexion = "jdbc:mysql://localhost:3306/coches";
				String user = "root";
				String pass = "";
						
				// Paso 2: Interactuar con la BD
				try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
					
					String sql = "DELETE FROM COCHE WHERE ID=?"; 
					
					//Scanner
					Scanner scan = new Scanner(System.in);
					System.out.println("Introduzca el id del coche que quiere eliminar");
					int id = scan.nextInt();
					
					System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
					System.out.println(sql);
					
					PreparedStatement sentencia = con.prepareStatement(sql);
					sentencia.setInt(1, id);
					
					//Como estamos cambiando registros, executeUpdate
					int afectados = sentencia.executeUpdate();
					System.out.println("Sentencia SQL ejecutada con éxito");
					System.out.println("Registros afectados: "+afectados);
				} catch (SQLException e) {
					System.out.println("Error al borrar el coche");
					System.out.println(e.getMessage());
				}
		
	}
	
	public static void exportarJson() {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coches";
		String user = "root";
		String pass = "";
		Coche coche = new Coche();//Aqui se recogeran los coches
		Gson gson = new Gson();
		String representacionJSON="";
		
	
		
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COCHE");
			ResultSet rs = sentencia.executeQuery();//no cambia registros, se usa para consultas
			while (rs.next()) {
				coche.setId(rs.getInt("ID"));
				coche.setMarca(rs.getString("MARCA"));
				coche.setModelo(rs.getString("MODELO"));
				coche.setMatricula(rs.getString("MATRICULA"));
				coche.setKm(rs.getInt("KM"));
				representacionJSON  = representacionJSON + gson.toJson(coche);
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}	
		
		escribirFicheroJson(representacionJSON);
		System.out.println("Se va a introducir en el fichero:");
		System.out.println(representacionJSON);
	}

	public static void exportarPdf() {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coches";
		String user = "root";
		String pass = "";
		PDPage myPage = new PDPage();
		Coche coche=new Coche();
		
		try (PDDocument doc = new PDDocument()) {
			doc.addPage(myPage);

			try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {
				cont.beginText();
				cont.setFont(PDType1Font.TIMES_ROMAN, 12);
				cont.newLineAtOffset(15, 750);
				try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
					PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COCHE");
					ResultSet rs = sentencia.executeQuery();
					cont.showText("COCHES:");
					cont.newLine();	
					cont.newLineAtOffset(0, -15);
					while (rs.next()) {
						coche.setId(rs.getInt("ID"));
						coche.setMarca(rs.getString("MARCA"));
						coche.setModelo(rs.getString("MODELO"));
						coche.setMatricula(rs.getString("MATRICULA"));
						coche.setKm(rs.getInt("KM"));
						String line=coche.toString();
						System.out.println(line);
						cont.showText(line);
						cont.newLine();	
						cont.newLineAtOffset(0, -15);
					}
				} catch (SQLException e) {
					System.out.println("Error al realizar el listado de productos");
					System.out.println(e.getMessage());
				}	


				cont.endText();				
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
			doc.save("src/main/resources/coches.pdf");
			System.out.println("Fichero pdf creado en src/main/resources/wwii.pdf");
			System.out.println("Refresque el proyecto en caso de que no aparezca");
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		
	}
	
	public static void escribirFicheroJson(String s) {
		try
        {
            String filePath = "src/main/resources/ficheroJSON.txt";
            FileWriter fw = new FileWriter(filePath, true);    
            fw.write(s);
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
		return;
    }
	
	public static Coche buscarId(int n) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/coches";
		String user = "root";
		String pass = "";
		
		
		
		// Paso 2: Interactuar con la BD 
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			
			Coche coche = new Coche();
			coche.setId(0);
			coche.setKm(0);
			coche.setMarca("");
			coche.setMatricula("");
			coche.setModelo("");
			//Scanner
			Scanner scan = new Scanner(System.in);
			System.out.println("Introduzca un id valido");
			int id= n;
			
			//Preparamos la sentencia
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COCHE WHERE ID=?");
			sentencia.setInt(1,id);
			ResultSet rs = sentencia.executeQuery();
			
			
			//Mostramos la coincidencia
			while (rs.next()) {
				System.out.print("ID:" + rs.getInt("ID"));
				System.out.print(" - "); 
				System.out.print("MATRICULA:" +rs.getString("MATRICULA"));
				System.out.print(" - "); 
				System.out.print("MARCA:" +rs.getString("MARCA"));
				System.out.print(" - "); 
				System.out.print("MODELO:" +rs.getString("MODELO"));
				System.out.print(" - "); 
				System.out.print("KM:" +rs.getInt("KM"));
				System.out.println(); 
				coche.setId(rs.getInt("ID"));
				coche.setKm(rs.getInt("KM"));
				coche.setMarca(rs.getString("MARCA"));
				coche.setMatricula(rs.getString("MATRICULA"));
				coche.setModelo(rs.getString("MODELO"));
				return coche;
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}		
		return null;
		
	}
}




