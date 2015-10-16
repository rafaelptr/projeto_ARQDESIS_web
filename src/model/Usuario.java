package model;

import factory.DAOFactory;
import to.UsuarioTO;

public class Usuario {
	public static final int ANTENDENTE = 1;
	public static final int ADMINISTRADOR = 2;
	
	private int id;
	private String usuario;
	private String senha;
	private int perfil;
	
	public UsuarioTO incluir(UsuarioTO to){
		return DAOFactory.getUsuarioDAO().incluir(to);
	}
	
	public UsuarioTO buscar(UsuarioTO to){
		return DAOFactory.getUsuarioDAO().buscar(to);
	}
	
	
	public Usuario(){
		this.usuario = "";
		this.senha = "";
		this.perfil = 0;
	}
	public Usuario(String usuario,String senha,int perfil){
		this.setSenha(senha);
		this.setPerfil(perfil);
		this.setUsuario(usuario);
	}
	public Usuario(String usuario,String senha){
		this.setSenha(senha);
		this.setUsuario(usuario);
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public String getUsuario() {
		return this.usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getPerfil() {
		return this.perfil;
	}
	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	
}

