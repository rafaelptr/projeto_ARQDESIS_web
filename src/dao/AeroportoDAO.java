package dao;

import java.sql.Connection;
import java.sql.SQLException;

import to.AeroportoTO;
import to.ListagemAeroportoTO;

public abstract class AeroportoDAO {
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract AeroportoTO incluir(AeroportoTO to);

	public abstract boolean remover(int id);
	
	public abstract ListagemAeroportoTO buscar(AeroportoTO to);
	
	public abstract ListagemAeroportoTO listagem();

	public abstract AeroportoTO alterar(AeroportoTO to);

	public abstract AeroportoTO buscarId(int id) ;
	

}
