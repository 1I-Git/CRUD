package ws.unai.crud.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ws.unai.crud.conexion.EstablecerConexion;
import ws.unai.crud.modelo.dao.UsuarioDao;
import ws.unai.crud.modelo.pojo.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	//Constructor
	public UsuarioDaoImpl() {
		super();
	}
	
	//Patron Singleton
	private static UsuarioDaoImpl INSTANCE = null;
	
	public static synchronized UsuarioDaoImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDaoImpl();
		}
		
		return INSTANCE;
		
	}
	
	//Sentencias SQL
	
	private final String SQL_GET_ALL = "SELECT * FROM usuario LIMIT 500;";
	private final String SQL_GET_BY_ID = "SELECT * FROM usuario WHERE id = ? ;";
	private final String SQL_INSERT = " INSERT INTO usuario (nombre, correo, direccion, telefono) VALUES ( ?, ?, ?, ?) ; ";
	private final String SQL_UPDATE = " UPDATE usuario SET nombre = ?, correo = ?,direccion = ?,telefono = ? WHERE id = ? ; ";
	private final String SQL_DELETE = " DELETE FROM usuario WHERE id = ? ; ";
	
	// Metodos de la interface
	
	//Obtener una lista de todos los Usuarios
	@Override
	public ArrayList<Usuario> getAll() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try (
				Connection con = EstablecerConexion.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();
				) {
			//Recorrer los resultados de la SQL
			while(rs.next()) {
				
				//Guardar datos de la BDD en Variables
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String correo = rs.getString("correo");
				String direccion = rs.getString("direccion");
				int telefono = rs.getInt("telefono");
				
				//Meter las variables en un OBJ(Usuario)
				Usuario u = new Usuario();
				u.setId(id);
				u.setNombre(nombre);
				u.setCorreo(correo);
				u.setDireccion(direccion);
				u.setTelefono(telefono);
				
				//Guardar el OBJ en el Array
				usuarios.add(u);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}

	//Obtener Usuario por su ID
	@Override
	public Usuario getById(int id) throws Exception {
		Usuario u = new Usuario();
		
		try (
				Connection con = EstablecerConexion.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID)
				) {
			//Introducir el parametro "id" en la SQL --> ?
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				//Introducir los datos de la BBDD en el obj creado
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setCorreo(rs.getString("correo"));
				u.setDireccion(rs.getString("direccion"));
				u.setTelefono(rs.getInt("telefono"));
				
			}else {
				throw new Exception("Id incorrecto");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	//Eliminar Usuario
	@Override
	public Usuario delete(int id) throws Exception {
		// Obtener usuario para eliminar
		
		Usuario usuario = getById(id);
		try (
				Connection con = EstablecerConexion.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);
				
				) {
			//Introducir el id en la SQL
			pst.setInt(1, id);
			int filasAfectadas = pst.executeUpdate();
			
			if (filasAfectadas != 1) {
				throw new Exception("No se puede eliminar");
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

	//Insertar Usuario
	@Override
	public Usuario insert(Usuario pojo) throws Exception {
		try (Connection conexion = EstablecerConexion.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

		) {
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCorreo());
			pst.setString(3, pojo.getDireccion());
			pst.setInt(4, pojo.getTelefono());
			pst.executeUpdate();

		}
		return pojo;
	}

	//Modificar Usuario
	@Override
	public Usuario update(Usuario pojo) throws Exception {
		if (pojo == null) {
			throw new Exception("Es null, no se puede modificar");
		}

		try (Connection con = EstablecerConexion.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCorreo());
			pst.setString(3, pojo.getDireccion());
			pst.setInt(4, pojo.getTelefono());
			pst.setInt(5, pojo.getId());
			
			int affectedRows = pst.executeUpdate();

			if (affectedRows != 1) {
				throw new Exception("No se puede modificar con id= " + pojo.getId());
			}

		} catch (SQLException e) {
			throw new Exception("Valores invalidos");
		}
		return pojo;
	}
	
}
