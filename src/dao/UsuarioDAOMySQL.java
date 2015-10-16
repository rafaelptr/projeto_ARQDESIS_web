package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import to.UsuarioTO;
import factory.ConnFactory;

public class UsuarioDAOMySQL extends UsuarioDAO{

	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	@Override
	public UsuarioTO incluir(UsuarioTO to){
		String inclusao = " INSERT INTO usuario( "
				+  " usuario, "
				+ " senha, "
				+ " perfil ) VALUES (?, ? , ?) ";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(inclusao);
			//configurar parametros
			pst.setString(1,to.usuario);
			pst.setString(2,to.senha);
			pst.setInt(3,to.perfil);
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
	public boolean remover(UsuarioTO to){
		String alteracao = "delete from usuario where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			//configurar parametros
			pst.setInt(1, to.id);
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
	public UsuarioTO buscar(UsuarioTO to){
		String selecao = 
				" SELECT * FROM usuario WHERE "
				+ " usuario = ?  and "
				+ " senha = ? "
				+ "";	
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(selecao);
			pst.setString(1, to.usuario);
			pst.setString(2, to.senha);
			to = null;
			rs = pst.executeQuery();

			if(rs.next()){
				to = new UsuarioTO();
				to.id = rs.getInt("id");
				to.usuario = rs.getString("usuario");
				to.senha = rs.getString("senha");
				to.perfil = rs.getInt("perfil");
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

}
