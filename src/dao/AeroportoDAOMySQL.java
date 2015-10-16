package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.AeroportoTO;
import to.ListagemAeroportoTO;
import factory.ConnFactory;

public class AeroportoDAOMySQL extends AeroportoDAO{

	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	@Override
	public AeroportoTO incluir(AeroportoTO to){
		String inclusao = " INSERT INTO aeroporto( "
				+ " nome, "
				+ " nomeCompleto, "
				+ " estado, "
				+ " pais, "
				+ " codigo "
				+ ") VALUES (?,?,?,?,?) ";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			System.out.println(inclusao);
			pst = conn.prepareStatement(inclusao);
			//configurar parametros
			pst.setString(1,to.nome);
			pst.setString(2,to.nomeCompleto);
			pst.setString(3,to.estado);
			pst.setString(4,to.pais);
			pst.setString(5,to.codigo);
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
		String alteracao = "delete from aeroporto where id=?";
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
	public AeroportoTO alterar(AeroportoTO to){
		String alteracao = " update aeroporto set "
				+ " nome = ?  ,"
				+ " estado = ?  ,"
				+ " pais = ?  ,"
				+ " nomeCompleto = ? , "
				+ " codigo = ?  "
				+ "where id = ? ";
		System.out.println(alteracao);
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			pst.setString(1,to.nome);
			pst.setString(2,to.estado);
			pst.setString(3,to.pais);
			pst.setString(4,to.nomeCompleto);
			pst.setString(5,to.codigo);
			pst.setInt(6,to.id);
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
	public AeroportoTO buscarId(int id) {
		String alteracao = " SELECT * FROM aeroporto "
				+ "where id = ? ";
		AeroportoTO to = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			pst.setInt(1,id);
			rs = pst.executeQuery();
			if(rs.next()){
				to = new AeroportoTO();
				to.id = rs.getInt("id");
				to.nomeCompleto = rs.getString("nomeCompleto");
				to.nome = rs.getString("nome");
				to.estado = rs.getString("estado");
				to.pais = rs.getString("pais");
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
	public ListagemAeroportoTO buscar(AeroportoTO toFiltro) {
		ListagemAeroportoTO listagemTO = new ListagemAeroportoTO();
		String search = " SELECT * FROM aeroporto WHERE " + this.prepareSearch(toFiltro);
				
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(search);
			rs = pst.executeQuery();
			while(rs.next()){
				AeroportoTO to = new AeroportoTO();
				to.id = rs.getInt("id");
				to.nomeCompleto = rs.getString("nomeCompleto");
				to.nome = rs.getString("nome");
				to.estado = rs.getString("estado");
				to.pais = rs.getString("pais");
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

	private String prepareSearch(AeroportoTO toFiltro) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public ListagemAeroportoTO listagem() {
		ListagemAeroportoTO listagemTO = new ListagemAeroportoTO();
		String alteracao = " SELECT * FROM aeroporto ";
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			rs = pst.executeQuery();
			while(rs.next()){
				AeroportoTO to = new AeroportoTO();
				to.id = rs.getInt("id");
				to.nomeCompleto = rs.getString("nomeCompleto");
				to.nome = rs.getString("nome");
				to.estado = rs.getString("estado");
				to.pais = rs.getString("pais");
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
