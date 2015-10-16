package dao;

import java.sql.Connection;
import java.sql.SQLException;

import to.AeronaveTO;
import to.ListagemAeronaveTO;

public abstract class AeronaveDAO {
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract AeronaveTO incluir(AeronaveTO to);

	public abstract boolean remover(int id);
	
	public abstract ListagemAeronaveTO buscar(AeronaveTO to);
	
	public abstract ListagemAeronaveTO listagem();

	public abstract AeronaveTO alterar(AeronaveTO to);

	public abstract AeronaveTO buscarId(int id) ;
	

}
