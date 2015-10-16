package model;

import factory.DAOFactory;
import to.PagamentoTO;
import to.ListagemPagamentoTO;

public class Pagamento {
	public static final String CREDITO = "Crédito";
	public static final String DEBITO = "Débito";
	public static final String DINHEIRO = "Dinheiro";
	
	private int id;
	private String status;
	private String tipo;
	private int cartaoId;
	private Cartao cartao;
	private String codigoTransacao;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the cartaoId
	 */
	public int getCartaoId() {
		return cartaoId;
	}
	/**
	 * @param cartaoId the cartaoId to set
	 */
	public void setCartaoId(int cartaoId) {
		this.cartaoId = cartaoId;
	}
	/**
	 * @return the cartao
	 */
	public Cartao getCartao() {
		return cartao;
	}
	/**
	 * @param cartao the cartao to set
	 */
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the codigoTransacao
	 */
	public String getCodigoTransacao() {
		return codigoTransacao;
	}
	/**
	 * @param codigoTransacao the codigoTransacao to set
	 */
	public void setCodigoTransacao(String codigoTransacao) {
		this.codigoTransacao = codigoTransacao;
	}

	
	public PagamentoTO incluir(PagamentoTO to){
		return DAOFactory.getPagamentoDAO().incluir(to);
	}
	
	public boolean remover(int id){
		return DAOFactory.getPagamentoDAO().remover(id);
	}
	public ListagemPagamentoTO buscar(PagamentoTO to){
		return DAOFactory.getPagamentoDAO().buscar(to);
	}
	public ListagemPagamentoTO listagem(){
		return DAOFactory.getPagamentoDAO().listagem();
	}
	public PagamentoTO alterar(PagamentoTO to){
		return DAOFactory.getPagamentoDAO().alterar(to);
	}
	public PagamentoTO buscarId(int id){
		return DAOFactory.getPagamentoDAO().buscarId(id);
	}
}
