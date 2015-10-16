package model;

import factory.DAOFactory;
import to.AssentoTO;
import to.ListagemAssentoTO;

public class Assento {
	private int id;
	private String classe;
	private int aeronaveId;
	private Assento aeronave;
	private String localizacao;
	/**
	 * @return the classe
	 */
	public String getClasse() {
		return classe;
	}
	/**
	 * @param classe the classe to set
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}
	/**
	 * @return the localizacao
	 */
	public String getLocalizacao() {
		return localizacao;
	}
	/**
	 * @param localizacao the localizacao to set
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	/**
	 * @return the aeronave
	 */
	public Assento getAssento() {
		return aeronave;
	}
	/**
	 * @param aeronave the aeronave to set
	 */
	public void setAssento(Assento aeronave) {
		this.aeronave = aeronave;
	}
	/**
	 * @return the aeronaveId
	 */
	public int getAssentoId() {
		return aeronaveId;
	}
	/**
	 * @param aeronaveId the aeronaveId to set
	 */
	public void setAssentoId(int aeronaveId) {
		this.aeronaveId = aeronaveId;
	}
	

	
	public AssentoTO incluir(AssentoTO to){
		return DAOFactory.getAssentoDAO().incluir(to);
	}
	
	public boolean remover(int id){
		return DAOFactory.getAssentoDAO().remover(id);
	}
	public ListagemAssentoTO buscar(AssentoTO to){
		return DAOFactory.getAssentoDAO().buscar(to);
	}
	public ListagemAssentoTO listagem(){
		return DAOFactory.getAssentoDAO().listagem();
	}
	public AssentoTO alterar(AssentoTO to){
		return DAOFactory.getAssentoDAO().alterar(to);
	}
	public AssentoTO buscarId(int id){
		return DAOFactory.getAssentoDAO().buscarId(id);
	}
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
}
