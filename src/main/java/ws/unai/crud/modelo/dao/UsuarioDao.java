package ws.unai.crud.modelo.dao;

import java.util.ArrayList;

import ws.unai.crud.modelo.pojo.Usuario;

public interface UsuarioDao {
	
	ArrayList<Usuario> getAll();

	Usuario getById(int id) throws Exception;

	Usuario delete(int id) throws Exception;

	Usuario insert(Usuario pojo) throws Exception;

	Usuario update(Usuario pojo) throws Exception;
}
