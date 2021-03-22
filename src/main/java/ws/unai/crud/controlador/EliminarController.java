package ws.unai.crud.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ws.unai.crud.modelo.dao.impl.*;


/**
 * Servlet implementation class EliminarController
 */
@WebServlet("/eliminar")
public class EliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Recoger id
			String idForm = request.getParameter("id");
			
			//Parsear Parametros
			
			int id = Integer.parseInt(idForm);
			
			//Crear OBJ 
			UsuarioDaoImpl objDao = UsuarioDaoImpl.getInstance();
			
			//Llamar al metodo delete
			objDao.delete(id);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			//Ir a la vista
			request.getRequestDispatcher("ver-usuarios").forward(request, response);
		}
	}

}
