package ws.unai.crud.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ws.unai.crud.modelo.dao.impl.*;
import ws.unai.crud.modelo.pojo.Usuario;


/**
 * Servlet implementation class CrearController
 */
@WebServlet("/crear")
public class CrearController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Creamos obj dao

				UsuarioDaoImpl objDao = UsuarioDaoImpl.getInstance();

				// Creamos un ArrayLis para guardar los usuarios del obj

				ArrayList<Usuario> usuarios = objDao.getAll();

				// Enviar informacion(Array de Usuarios) a la vista

				request.setAttribute("usuarios", usuarios);

				// Enviar a la vista leer.jsp
				request.getRequestDispatcher("gestion.jsp").forward(request, response);
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//recoger Parametros Form
			
			String nombre = request.getParameter("nombre");
			String correo = request.getParameter("correo");
			String direccion = request.getParameter("direccion");
			String tel = request.getParameter("telefono");
			
			//Parsear Parametros
			int telefono = Integer.parseInt( tel);
			
			//Almacenar datos en la BDD
			UsuarioDaoImpl objDao = UsuarioDaoImpl.getInstance();
			
			Usuario u = new Usuario();
			
			u.setNombre(nombre);
			u.setCorreo(correo);
			u.setDireccion(direccion);
			u.setTelefono(telefono);
			
			//Llamar al metodo Insert
			
			objDao.insert(u);
			
			//Ir a la vista
			request.getRequestDispatcher("ver-usuarios").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
