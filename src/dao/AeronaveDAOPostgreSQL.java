package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.AeronaveTO;
import to.ListagemAeronaveTO;
import factory.ConnFactory;

public class AeronaveDAOPostgreSQL extends AeronaveDAO{

	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	@Override
	public AeronaveTO incluir(AeronaveTO to){
		String inclusao = " INSERT INTO aeronave( "
				+  " codigo, "
				+ " nome, "
				+ " qtdAssentosA, "
				+" qtdAssentosB, "
				+ "qtdAssentosC, "
				+ "qtdAssentosHorizontais, "
				+ "qtdAssentosVerticais "
				+ ") VALUES (?, ? , ?, ?, ? ,? ,?) ";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			System.out.println(inclusao);
			pst = conn.prepareStatement(inclusao);
			//configurar parametros
			pst.setString(1,to.codigo);
			pst.setString(2,to.nome);
			pst.setInt(3,to.qtdAssentosA);
			pst.setInt(4,to.qtdAssentosB);
			pst.setInt(5,to.qtdAssentosC);
			pst.setInt(6,to.qtdAssentosHorizontais);
			pst.setInt(7,to.qtdAssentosVerticais);
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
		String alteracao = "delete from aeronave where id=?";
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
	public AeronaveTO alterar(AeronaveTO to){
		String alteracao = " update aeronave set "
				+  " codigo = ? , "
				+ " nome = ? , "
				+ " qtdAssentosA = ? , "
				+" qtdAssentosB = ? , "
				+ "qtdAssentosC = ? , "
				+ "qtdAssentosHorizontais = ? , "
				+ "qtdAssentosVerticais = ? "
				+ "where id = ? ";
		System.out.println(alteracao);
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			pst.setString(1,to.codigo);
			pst.setString(2,to.nome);
			pst.setInt(3,to.qtdAssentosA);
			pst.setInt(4,to.qtdAssentosB);
			pst.setInt(5,to.qtdAssentosC);
			pst.setInt(6,to.qtdAssentosHorizontais);
			pst.setInt(7,to.qtdAssentosVerticais);
			pst.setInt(8,to.id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			to = null;
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
	public AeronaveTO buscarId(int id) {
		String alteracao = " SELECT * FROM aeronave "
				+ "where id = ? ";
		AeronaveTO to = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			pst.setInt(1,id);
			rs = pst.executeQuery();
			if(rs.next()){
				to = new AeronaveTO();
				to.id = rs.getInt("id");
				to.codigo = rs.getString("codigo");
				to.nome = rs.getString("nome");
				to.qtdAssentosA = rs.getInt("qtdAssentosA");
				to.qtdAssentosB = rs.getInt("qtdAssentosB");
				to.qtdAssentosC = rs.getInt("qtdAssentosC");
				to.qtdAssentosHorizontais = rs.getInt("qtdAssentosHorizontais");
				to.qtdAssentosVerticais = rs.getInt("qtdAssentosVerticais");
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
	public ListagemAeronaveTO buscar(AeronaveTO toFiltro) {
		ListagemAeronaveTO listagemTO = new ListagemAeronaveTO();
		String search = " SELECT * FROM aeronave WHERE " + this.prepareSearch(toFiltro);
				
		
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(search);
			rs = pst.executeQuery();
			if(rs.next()){
				AeronaveTO to = new AeronaveTO();
				to.id = rs.getInt("id");
				to.codigo = rs.getString("codigo");
				to.nome = rs.getString("nome");
				to.qtdAssentosA = rs.getInt("qtdAssentosA");
				to.qtdAssentosB = rs.getInt("qtdAssentosB");
				to.qtdAssentosC = rs.getInt("qtdAssentosC");
				to.qtdAssentosHorizontais = rs.getInt("qtdAssentosHorizontais");
				to.qtdAssentosVerticais = rs.getInt("qtdAssentosVerticais");
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

	private String prepareSearch(AeronaveTO toFiltro) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public ListagemAeronaveTO listagem() {
		ListagemAeronaveTO listagemTO = new ListagemAeronaveTO();
		String alteracao = " SELECT * FROM aeronave ";
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			rs = pst.executeQuery();
			while(rs.next()){
				AeronaveTO to = new AeronaveTO();
				to.id = rs.getInt("id");
				to.codigo = rs.getString("codigo");
				to.nome = rs.getString("nome");
				to.qtdAssentosA = rs.getInt("qtdAssentosA");
				to.qtdAssentosB = rs.getInt("qtdAssentosB");
				to.qtdAssentosC = rs.getInt("qtdAssentosC");
				to.qtdAssentosHorizontais = rs.getInt("qtdAssentosHorizontais");
				to.qtdAssentosVerticais = rs.getInt("qtdAssentosVerticais");
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
