package languages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;


public class Idioma {
	
	public static final int PT_BR = 0;
	public static final int EN_US = 1;
	public static final int ES_ES = 2;
	
	public static void inicializar(HttpServletRequest request){
		if(request.getSession().getAttribute("idiomaSelecionadoBundle") == null){
			trocarIdioma(request, PT_BR);
		}
	}
	
	public static void trocarIdioma(HttpServletRequest request,int index){
		Locale idioma_locale = null;
		ResourceBundle idiomaSelecionadoBundle = null; 
		int idiomaSelecionado = index;
		switch (index) {
		case PT_BR:
				idioma_locale = new Locale("pt","BR");
				idiomaSelecionadoBundle = ResourceBundle.getBundle("Language",idioma_locale);
				idiomaSelecionado = PT_BR;
			break;
		case EN_US:
				idioma_locale = new Locale("en","US");
				idiomaSelecionadoBundle = ResourceBundle.getBundle("Language",idioma_locale);
				idiomaSelecionado = EN_US;
			break;
		case ES_ES:
				idioma_locale = new Locale("es","ES");
				idiomaSelecionadoBundle = ResourceBundle.getBundle("Language",idioma_locale);
				idiomaSelecionado = ES_ES;
			break;
		default:
			idioma_locale = new Locale("pt","BR");
			idiomaSelecionadoBundle = ResourceBundle.getBundle("Language",idioma_locale);
			idiomaSelecionado = PT_BR;
			break;
		}
		request.getSession().setAttribute("idiomaSelecionadoBundle", idiomaSelecionadoBundle);
		request.getSession().setAttribute("idiomaSelecionado", idiomaSelecionado);
	}
	
	public static String para(HttpServletRequest request,String chave){
		ResourceBundle idiomaSelecionadoBundle = (ResourceBundle)request.getSession().getAttribute("idiomaSelecionadoBundle");
		if(idiomaSelecionadoBundle != null){
			if(idiomaSelecionadoBundle.containsKey(chave))
			{
				return idiomaSelecionadoBundle.getString(chave);
			} 
		}
		return "--["+chave+"]--";
	}
}
