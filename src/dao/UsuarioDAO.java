package dao;

import java.sql.Connection;
import java.sql.SQLException;

import to.UsuarioTO;

public abstract class UsuarioDAO {
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract UsuarioTO incluir(UsuarioTO to);

	public abstract boolean remover(UsuarioTO to);
	
	public abstract UsuarioTO buscar(UsuarioTO to);
	

}
