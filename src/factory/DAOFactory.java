package factory;

import dao.*;

public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new UsuarioDAOMySQL();
		case ConnFactory.POSTGRE:
			return new UsuarioDAOPostgreSQL();
		default:
			return null;
		}
	}
	
	public static AeronaveDAO getAeronaveDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new AeronaveDAOMySQL();
		case ConnFactory.POSTGRE:
			return new AeronaveDAOPostgreSQL();
		default:
			return null;
		}
	}
	public static AeroportoDAO getAeroportoDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new AeroportoDAOMySQL();
		case ConnFactory.POSTGRE:
			return new AeroportoDAOPostgreSQL();
		default:
			return null;
		}
	}
	public static AssentoDAO getAssentoDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new AssentoDAOMySQL();
		case ConnFactory.POSTGRE:
			return new AssentoDAOPostgreSQL();
		default:
			return null;
		}
	}
	public static BilheteDAO getBilheteDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new BilheteDAOMySQL();
		case ConnFactory.POSTGRE:
			return new BilheteDAOPostgreSQL();
		default:
			return null;
		}
	}
	public static CartaoDAO getCartaoDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new CartaoDAOMySQL();
		case ConnFactory.POSTGRE:
			return new CartaoDAOPostgreSQL();
		default:
			return null;
		}
	}
	public static PagamentoDAO getPagamentoDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new PagamentoDAOMySQL();
		case ConnFactory.POSTGRE:
			return new PagamentoDAOPostgreSQL();
		default:
			return null;
		}
	}
	public static PassageiroDAO getPassageiroDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new PassageiroDAOMySQL();
		case ConnFactory.POSTGRE:
			return new PassageiroDAOPostgreSQL();
		default:
			return null;
		}
	} 
	public static VooDAO getVooDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new VooDAOMySQL();
		case ConnFactory.POSTGRE:
			return new VooDAOPostgreSQL();
		default:
			return null;
		}
	}
}
