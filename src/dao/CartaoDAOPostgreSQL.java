package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.CartaoTO;
import to.ListagemCartaoTO;
import factory.ConnFactory;

public class CartaoDAOPostgreSQL extends CartaoDAO{

	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	@Override
	public CartaoTO incluir(CartaoTO to){
		String inclusao = " INSERT INTO cartao( "
				+  " codigo, "
				+ " nome, "
				+ " qtdAssentosA, "
				+" qtdAssentosB, "
				+ "qtdAssentosC, "
				+ "qtdAssentosHorizontais, "
				+ "qtdAssentosVerticais, "
				+ ") VALUES (?, ? , ?, ?, ? ,? ,?) ";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(inclusao);
			//configurar parametros
			pst.execute();
			//funcao do MySQL para pegar o ultimo id inserido nesta secao"
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			String selecao = "select LAST_INSERT_ID()";
			pst = conn.prepareStatement(selecao);
			rs = pst.executeQuery();
			if(rs.next()){
				to.id = rs.getInt(1);
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return to;
	}

	@Override
	public boolean remover(int to){
		String alteracao = "delete from cartao where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			//configurar parametros
			pst.setInt(1, to);
			//fim configurar parametros
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	@Override
	public CartaoTO alterar(CartaoTO to){
		String alteracao = " update cartao set( "
				+  " codigo, "
				+ " nome, "
				+ " qtdAssentosA, "
				+" qtdAssentosB, "
				+ "qtdAssentosC, "
				+ "qtdAssentosHorizontais, "
				+ "qtdAssentosVerticais, "
				+ ") VALUES (?, ? , ?, ?, ? ,? ,?) where id = ? ";
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			pst.setInt(8,to.id);
			to = null;
			rs = pst.executeQuery();
			if(rs.next()){
				to = new CartaoTO();
				to.id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return to;
	}

	@Override
	public CartaoTO buscarId(int id) {
		String alteracao = " SELECT * FROM cartao "
				+ "where id = ? ";
		CartaoTO to = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			pst.setInt(1,id);
			rs = pst.executeQuery();
			if(rs.next()){
				to = new CartaoTO();
				to.id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return to;
	}

	@Override
	public ListagemCartaoTO buscar(CartaoTO toFiltro) {
		ListagemCartaoTO listagemTO = new ListagemCartaoTO();
		String search = " SELECT * FROM cartao WHERE " + this.prepareSearch(toFiltro);
				
		
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(search);
			rs = pst.executeQuery();
			while(rs.next()){
				CartaoTO to = new CartaoTO();
				to.id = rs.getInt("id");
				listagemTO.add(to);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listagemTO;
	}

	private String prepareSearch(CartaoTO toFiltro) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public ListagemCartaoTO listagem() {
		ListagemCartaoTO listagemTO = new ListagemCartaoTO();
		String alteracao = " SELECT * FROM cartao ";
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			rs = pst.executeQuery();
			while(rs.next()){
				CartaoTO to = new CartaoTO();
				to.id = rs.getInt("id");
				listagemTO.add(to);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listagemTO;
	}

}
