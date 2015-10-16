package utils;

import javax.servlet.http.HttpServletRequest;

import to.UsuarioTO;

public class DadosSessao {
	
	public static String usuarioLogado(HttpServletRequest request){
		UsuarioTO to = (UsuarioTO)request.getSession().getAttribute("usuarioLogado");
		if(to != null){
			return to.usuario;
		}
		return "";
	}
	
	public static int usuarioPefil(HttpServletRequest request){
		UsuarioTO to = (UsuarioTO)request.getSession().getAttribute("usuarioLogado");
		if(to != null){
			return to.perfil;
		}
		return 0;
	}
	
	public static boolean logado(HttpServletRequest request){
		return (boolean) (request.getSession().getAttribute("logado") == null ? false : request.getSession().getAttribute("logado"));
	}
}
