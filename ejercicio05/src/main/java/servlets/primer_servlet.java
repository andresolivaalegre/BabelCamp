package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Usuario;


@WebServlet("/primer_servlet")
public class primer_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public primer_servlet() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario u1 = new Usuario();
		u1.setNombre("usuario1");
		u1.setContrasenia("1234");
		
		Usuario u2 = new Usuario();
		u2.setNombre("usuario2");
		u2.setContrasenia("12345");
		
		Usuario u3 = new Usuario();
		u3.setNombre("usuario3");
		u3.setContrasenia("123456");
		
		ArrayList<Usuario> usuarios =new ArrayList<Usuario>();
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);

		String nombre = request.getParameter("nombre");//igual que el name del html
		String contrasenia = request.getParameter("contrasenia");
		
		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setContrasenia(contrasenia);
		
		boolean encontrado=false;
		
		for(int i=0; i<usuarios.size() && !encontrado &&  contrasenia != null; i++) {
		if(nombre.equals(usuarios.get(i).getNombre()))
			if(contrasenia.equals(usuarios.get(i).getContrasenia()))
				encontrado=true;
		}
		
		if(encontrado) {
			RequestDispatcher rd1 = request.getRequestDispatcher("Exito.jsp");
			request.setAttribute("u1", nombre);
			rd1.forward(request, response);
		} else {
			RequestDispatcher rd2 = request.getRequestDispatcher("fracaso.jsp");
			request.setAttribute("u1", nombre);
			rd2.forward(request, response);
		}
		
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
