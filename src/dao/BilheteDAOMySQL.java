package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.BilheteTO;
import to.ListagemBilheteTO;
import factory.ConnFactory;

public class BilheteDAOMySQL extends BilheteDAO{

	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	@Override
	public BilheteTO incluir(BilheteTO to){
//		to.codigo
//		to.id
//		to.nome
//		to.qtdAssentosA
//		to.qtdAssentosB
//		to.qtdAssentosC
//		to.qtdAssentosHorizontais
//		to.qtdAssentosVerticais
		String inclusao = " INSERT INTO bilhete( "
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
			pst.setString(1,to.codigo);
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
	public boolean remover(int id){
		String alteracao = "delete from bilhete where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			//configurar parametros
			pst.setInt(1, id);
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
	public BilheteTO alterar(BilheteTO to){
		String alteracao = " update bilhete set( "
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
			pst.setString(1,to.codigo);
			pst.setInt(8,to.id);
			to = null;
			rs = pst.executeQuery();
			if(rs.next()){
				to = new BilheteTO();
				to.id = rs.getInt("id");
				to.codigo = rs.getString("codigo");
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
	public BilheteTO buscarId(int id) {
		String alteracao = " SELECT * FROM bilhete "
				+ "where id = ? ";
		BilheteTO to = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			pst.setInt(1,id);
			rs = pst.executeQuery();
			if(rs.next()){
				to = new BilheteTO();
				to.id = rs.getInt("id");
				to.codigo = rs.getString("codigo");
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
	public ListagemBilheteTO buscar(BilheteTO toFiltro) {
		ListagemBilheteTO listagemTO = new ListagemBilheteTO();
		String search = " SELECT * FROM bilhete WHERE " + this.prepareSearch(toFiltro);
				
		
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(search);
			rs = pst.executeQuery();
			if(rs.next()){
				BilheteTO to = new BilheteTO();
				to.id = rs.getInt("id");
				to.codigo = rs.getString("codigo");
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

	private String prepareSearch(BilheteTO toFiltro) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public ListagemBilheteTO listagem() {
		ListagemBilheteTO listagemTO = new ListagemBilheteTO();
		String alteracao = " SELECT * FROM bilhete ";
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			rs = pst.executeQuery();
			while(rs.next()){
				BilheteTO to = new BilheteTO();
				to.id = rs.getInt("id");
				to.codigo = rs.getString("codigo");
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
