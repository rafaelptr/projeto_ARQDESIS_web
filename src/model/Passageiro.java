package model;

import factory.DAOFactory;
import to.PassageiroTO;
import to.ListagemPassageiroTO;

public class Passageiro {
	private int id;
	private String nome;
	private String cpf;
	private int bilheteId;
	private Bilhete bilhete;
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the bilheteId
	 */
	public int getBilheteId() {
		return bilheteId;
	}
	/**
	 * @param bilheteId the bilheteId to set
	 */
	public void setBilheteId(int bilheteId) {
		this.bilheteId = bilheteId;
	}
	/**
	 * @return the bilhete
	 */
	public Bilhete getBilhete() {
		return bilhete;
	}
	/**
	 * @param bilhete the bilhete to set
	 */
	public void setBilhete(Bilhete bilhete) {
		this.bilhete = bilhete;
	}
	

	
	public PassageiroTO incluir(PassageiroTO to){
		return DAOFactory.getPassageiroDAO().incluir(to);
	}
	
	public boolean remover(int id){
		return DAOFactory.getPassageiroDAO().remover(id);
	}
	public ListagemPassageiroTO buscar(PassageiroTO to){
		return DAOFactory.getPassageiroDAO().buscar(to);
	}
	public ListagemPassageiroTO listagem(){
		return DAOFactory.getPassageiroDAO().listagem();
	}
	public PassageiroTO alterar(PassageiroTO to){
		return DAOFactory.getPassageiroDAO().alterar(to);
	}
	public PassageiroTO buscarId(int id){
		return DAOFactory.getPassageiroDAO().buscarId(id);
	}
}
