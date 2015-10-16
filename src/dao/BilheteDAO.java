package dao;

import java.sql.Connection;
import java.sql.SQLException;

import to.BilheteTO;
import to.ListagemBilheteTO;

public abstract class BilheteDAO {
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract BilheteTO incluir(BilheteTO to);

	public abstract boolean remover(int id);
	
	public abstract ListagemBilheteTO buscar(BilheteTO to);
	
	public abstract ListagemBilheteTO listagem();

	public abstract BilheteTO alterar(BilheteTO to);

	public abstract BilheteTO buscarId(int id) ;
	

}
