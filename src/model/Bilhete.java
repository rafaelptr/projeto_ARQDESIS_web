package model;

import factory.DAOFactory;
import to.BilheteTO;
import to.ListagemBilheteTO;

public class Bilhete {
	private int id; 
	private String codigo;
	private int passageiroId;
	private Passageiro passageiro;
	private int pagamentoId;
	private Pagamento pagamento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getPassageiroId() {
		return passageiroId;
	}
	public void setPassageiroId(int passageiroId) {
		this.passageiroId = passageiroId;
	}
	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	public int getPagamentoId() {
		return pagamentoId;
	}
	public void setPagamentoId(int pagamentoId) {
		this.pagamentoId = pagamentoId;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	

	
	public BilheteTO incluir(BilheteTO to){
		return DAOFactory.getBilheteDAO().incluir(to);
	}
	
	public boolean remover(int id){
		return DAOFactory.getBilheteDAO().remover(id);
	}
	public ListagemBilheteTO buscar(BilheteTO to){
		return DAOFactory.getBilheteDAO().buscar(to);
	}
	public ListagemBilheteTO listagem(){
		return DAOFactory.getBilheteDAO().listagem();
	}
	public BilheteTO alterar(BilheteTO to){
		return DAOFactory.getBilheteDAO().alterar(to);
	}
	public BilheteTO buscarId(int id){
		return DAOFactory.getBilheteDAO().buscarId(id);
	}
}
