package dao;

import java.sql.Connection;
import java.sql.SQLException;

import to.VooTO;
import to.ListagemVooTO;

public abstract class VooDAO {
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract VooTO incluir(VooTO to);

	public abstract boolean remover(int to);
	
	public abstract ListagemVooTO buscar(VooTO to);
	
	public abstract ListagemVooTO listagem();

	public abstract VooTO alterar(VooTO to);

	public abstract VooTO buscarId(int id) ;
	

}
