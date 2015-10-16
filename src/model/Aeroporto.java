package model;

import factory.DAOFactory;
import to.AeroportoTO;
import to.ListagemAeroportoTO;

public class Aeroporto {
	private int id;
	private String nome;
	private String codigo;
	private String nomeCompleto = "";
	private String estado;
	private String pais;
	
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
	

	
	public AeroportoTO incluir(AeroportoTO to){
		return DAOFactory.getAeroportoDAO().incluir(to);
	}
	
	public boolean remover(int id){
		return DAOFactory.getAeroportoDAO().remover(id);
	}
	public ListagemAeroportoTO buscar(AeroportoTO to){
		return DAOFactory.getAeroportoDAO().buscar(to);
	}
	public ListagemAeroportoTO listagem(){
		return DAOFactory.getAeroportoDAO().listagem();
	}
	public AeroportoTO alterar(AeroportoTO to){
		return DAOFactory.getAeroportoDAO().alterar(to);
	}
	public AeroportoTO buscarId(int id){
		return DAOFactory.getAeroportoDAO().buscarId(id);
	}
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the nomeCompleto
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	/**
	 * @param nomeCompleto the nomeCompleto to set
	 */
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
