package ws.unai.crud.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ws.unai.crud.modelo.dao.impl.*;
import ws.unai.crud.modelo.pojo.Usuario;

/**
 * Servlet implementation class EditarController
 */
@WebServlet("/editar")
public class EditarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recoger parametro
		String parametroId = request.getParameter("id");
		
		// Enviar a la vista leer.jsp
		request.setAttribute("id", parametroId);
		request.getRequestDispatcher("editar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// Recoger Parametros
			String idForm = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String correo = request.getParameter("correo");
			String direccion = request.getParameter("direccion");
			String telForm = request.getParameter("telefono");
			
			//Parsear Parametros
			int telefono = Integer.parseInt(telForm);
			int id = Integer.parseInt(idForm);
			
			//Editar datos en la BDD
			UsuarioDaoImpl objDao = UsuarioDaoImpl.getInstance();
			
			Usuario u = new Usuario();
			
			u.setId(id);
			u.setNombre(nombre);
			u.setCorreo(correo);
			u.setDireccion(direccion);
			u.setTelefono(telefono);
			
			//LLamar al metodo update
			
			objDao.update(u);
			
			//Ir a la vista
			request.getRequestDispatcher("ver-usuarios").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
