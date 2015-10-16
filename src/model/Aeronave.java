package model;

import java.util.ArrayList;

import factory.DAOFactory;
import to.AeronaveTO;
import to.ListagemAeronaveTO;

public class Aeronave {
	
	private int id;
	private String codigo;
	private String nome;
	private int qtdAssentosA;
	private int qtdAssentosB;
	private int qtdAssentosC;
	private int qtdAssentosHorizontais;
	private int qtdAssentosVerticais;
	private ArrayList<Assento> assentos; 

	public Aeronave(){
		this.id = 0;
		this.codigo = "";
		this.nome = "";
		this.qtdAssentosA = 0;
		this.qtdAssentosB = 0;
		this.qtdAssentosC = 0;
		this.qtdAssentosHorizontais = 0;
		this.qtdAssentosVerticais = 0;
	}

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTotalAssentos() {
		return this.qtdAssentosA + this.qtdAssentosB + this.qtdAssentosC;
	}

	public int getQtdAssentosA() {
		return qtdAssentosA;
	}

	public void setQtdAssentosA(int qtdAssentosA) {
		this.qtdAssentosA = qtdAssentosA;
	}

	public int getQtdAssentosB() {
		return qtdAssentosB;
	}

	public void setQtdAssentosB(int qtdAssentosB) {
		this.qtdAssentosB = qtdAssentosB;
	}

	public int getQtdAssentosC() {
		return qtdAssentosC;
	}

	public void setQtdAssentosC(int qtdAssentosC) {
		this.qtdAssentosC = qtdAssentosC;
	}

	public int getsetQtdAssentosHorizontais() {
		return qtdAssentosHorizontais;
	}

	public void setQtdAssentosHorizontais(int qtdAssentosHorizontais) {
		this.qtdAssentosHorizontais = qtdAssentosHorizontais;
	}

	public int getQtdAssentosVerticais() {
		return qtdAssentosVerticais;
	}

	public void setQtdAssentosVerticais(int qtdAssentosVerticais) {
		this.qtdAssentosVerticais = qtdAssentosVerticais;
	}

	/**
	 * @return the assentos
	 */
	public ArrayList<Assento> getAssentos() {
		return assentos;
	}

	/**
	 * @param assentos the assentos to set
	 */
	public void setAssentos(ArrayList<Assento> assentos) {
		this.assentos = assentos;
	}
	
	
	
	
	public AeronaveTO incluir(AeronaveTO to){
		return DAOFactory.getAeronaveDAO().incluir(to);
	}
	
	public boolean remover(int id){
		return DAOFactory.getAeronaveDAO().remover(id);
	}
	public ListagemAeronaveTO buscar(AeronaveTO to){
		return DAOFactory.getAeronaveDAO().buscar(to);
	}
	public ListagemAeronaveTO listagem(){
		return DAOFactory.getAeronaveDAO().listagem();
	}
	public AeronaveTO alterar(AeronaveTO to){
		return DAOFactory.getAeronaveDAO().alterar(to);
	}
	public AeronaveTO buscarId(int id){
		return DAOFactory.getAeronaveDAO().buscarId(id);
	}
	
}

