package model;

import java.util.ArrayList;
import java.util.Date;

import factory.DAOFactory;
import to.VooTO;
import to.ListagemVooTO;

public class Voo {
	
	private int id;
	private String nome;
	private String codigo;
	private int aeronaveId;
	private Aeronave aeronave;
	private int aeroportoOrigemId;
	private Aeroporto aeroportoOrigem;
	private int aeroportoDestinoId;
	private Aeroporto aeroportoDestino;
	private double preco;
	private ArrayList<Passageiro> passageiros;
	private Date data;

	public Voo(){
		this.id = 0;
		this.nome = "";
		this.codigo = "";
		this.preco = 0.0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	

	/**
	 * @return the passageiros
	 */
	public ArrayList<Passageiro> getPassageiros() {
		return passageiros;
	}

	/**
	 * @param passageiros the passageiros to set
	 */
	public void setPassageiros(ArrayList<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}

	/**
	 * @return the aeroportoDestino
	 */
	public Aeroporto getAeroportoDestino() {
		return aeroportoDestino;
	}

	/**
	 * @param aeroportoDestino the aeroportoDestino to set
	 */
	public void setAeroportoDestino(Aeroporto aeroportoDestino) {
		this.aeroportoDestino = aeroportoDestino;
	}

	/**
	 * @return the aeroportoDestinoId
	 */
	public int getAeroportoDestinoId() {
		return aeroportoDestinoId;
	}

	/**
	 * @param aeroportoDestinoId the aeroportoDestinoId to set
	 */
	public void setAeroportoDestinoId(int aeroportoDestinoId) {
		this.aeroportoDestinoId = aeroportoDestinoId;
	}

	/**
	 * @return the aeroportoOrigem
	 */
	public Aeroporto getAeroportoOrigem() {
		return aeroportoOrigem;
	}

	/**
	 * @param aeroportoOrigem the aeroportoOrigem to set
	 */
	public void setAeroportoOrigem(Aeroporto aeroportoOrigem) {
		this.aeroportoOrigem = aeroportoOrigem;
	}

	/**
	 * @return the aeroportoOrigemId
	 */
	public int getAeroportoOrigemId() {
		return aeroportoOrigemId;
	}

	/**
	 * @param aeroportoOrigemId the aeroportoOrigemId to set
	 */
	public void setAeroportoOrigemId(int aeroportoOrigemId) {
		this.aeroportoOrigemId = aeroportoOrigemId;
	}

	/**
	 * @return the aeronave
	 */
	public Aeronave getAeronave() {
		return aeronave;
	}

	/**
	 * @param aeronave the aeronave to set
	 */
	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
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

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the aeronaveId
	 */
	public int getAeronaveId() {
		return aeronaveId;
	}

	/**
	 * @param aeronaveId the aeronaveId to set
	 */
	public void setAeronaveId(int aeronaveId) {
		this.aeronaveId = aeronaveId;
	}

	

	
	public VooTO incluir(VooTO to){
		return DAOFactory.getVooDAO().incluir(to);
	}
	
	public boolean remover(int id){
		return DAOFactory.getVooDAO().remover(id);
	}
	public ListagemVooTO buscar(VooTO to){
		return DAOFactory.getVooDAO().buscar(to);
	}
	public ListagemVooTO listagem(){
		return DAOFactory.getVooDAO().listagem();
	}
	public VooTO alterar(VooTO to){
		return DAOFactory.getVooDAO().alterar(to);
	}
	public VooTO buscarId(int id){
		return DAOFactory.getVooDAO().buscarId(id);
	}
	
}

