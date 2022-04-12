package login;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class GestorLogin {
	
	public static boolean validarUsuario() {
		try (Scanner sc = new Scanner(System.in)) {
			String nombre="";
			String contrasenia="";
			boolean haEntrado = false;
			do {

				System.out.println("Introduzca el nombre de usuario");
				nombre = sc.next();
				System.out.println("Introduzca la contraseña");
				contrasenia = sc.next();

				try {
					HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://localhost:8080/usuarios/usuarios/login?nombre="+ nombre + "&password=" + contrasenia)).GET().build();
					HttpClient client = HttpClient.newHttpClient();
					HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
					JSONObject json = new JSONObject(response.body());
					haEntrado = json.getBoolean("validado");
					return true;
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} while (!haEntrado);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
