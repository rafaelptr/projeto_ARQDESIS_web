package dao;

import java.sql.Connection;
import java.sql.SQLException;

import to.AssentoTO;
import to.ListagemAssentoTO;

public abstract class AssentoDAO {
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract AssentoTO incluir(AssentoTO to);

	public abstract boolean remover(int id);
	
	public abstract ListagemAssentoTO buscar(AssentoTO to);
	
	public abstract ListagemAssentoTO listagem();

	public abstract AssentoTO alterar(AssentoTO to);

	public abstract AssentoTO buscarId(int id) ;
	

}
