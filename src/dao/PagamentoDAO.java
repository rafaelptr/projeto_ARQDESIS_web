package dao;

import java.sql.Connection;
import java.sql.SQLException;

import to.PagamentoTO;
import to.ListagemPagamentoTO;

public abstract class PagamentoDAO {
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract PagamentoTO incluir(PagamentoTO to);

	public abstract boolean remover(int to);
	
	public abstract ListagemPagamentoTO buscar(PagamentoTO to);
	
	public abstract ListagemPagamentoTO listagem();

	public abstract PagamentoTO alterar(PagamentoTO to);

	public abstract PagamentoTO buscarId(int id) ;
	

}
