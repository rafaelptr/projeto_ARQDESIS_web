package dao;

import java.sql.Connection;
import java.sql.SQLException;

import to.PassageiroTO;
import to.ListagemPassageiroTO;

public abstract class PassageiroDAO {
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract PassageiroTO incluir(PassageiroTO to);

	public abstract boolean remover(int to);
	
	public abstract ListagemPassageiroTO buscar(PassageiroTO to);
	
	public abstract ListagemPassageiroTO listagem();

	public abstract PassageiroTO alterar(PassageiroTO to);

	public abstract PassageiroTO buscarId(int id) ;
	

}
