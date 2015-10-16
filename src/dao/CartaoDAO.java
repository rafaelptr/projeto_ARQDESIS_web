package dao;

import java.sql.Connection;
import java.sql.SQLException;

import to.CartaoTO;
import to.ListagemCartaoTO;

public abstract class CartaoDAO {
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract CartaoTO incluir(CartaoTO to);

	public abstract boolean remover(int id);
	
	public abstract ListagemCartaoTO buscar(CartaoTO to);
	
	public abstract ListagemCartaoTO listagem();

	public abstract CartaoTO alterar(CartaoTO to);

	public abstract CartaoTO buscarId(int id) ;
	

}
