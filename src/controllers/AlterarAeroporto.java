package controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aeroporto;
import to.AeroportoTO;

/**
 * Servlet implementation class AeroportoController
 */
@WebServlet("/AlterarAeroporto")
public class AlterarAeroporto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarAeroporto() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = 0;
    	String Stringid = (request.getParameter("id") != null ? request.getParameter("id") : "0");
    	String view = "views/aeroporto/alterar.jsp";
    	try{
    		id = Integer.parseInt(Stringid);
    	}catch(NumberFormatException e) {
    		request.setAttribute("erroMsg", "dados_invalidos_erro");
    		view = "./ListagemAeroporto";
    	}
    	if(id > 0){
    		Aeroporto aeroporto = new Aeroporto();
    		AeroportoTO to = aeroporto.buscarId(id);
    		request.setAttribute("aeroporto", to);
    	}
    	request.getRequestDispatcher(view).forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Aeroporto aeroporto = new Aeroporto();
         AeroportoTO aeroportoTo = new AeroportoTO();			 
	 	 String view = "views/aeroporto/alterar.jsp";
    	String Stringid = (request.getParameter("id") != null ? request.getParameter("id") : "0");
    	try{
    		aeroportoTo.id = Integer.parseInt(Stringid);
    	}catch(NumberFormatException e) {
    		request.setAttribute("erroMsg", "dados_invalidos_erro");
    		view = "./ListagemAeroporto";
    	}
    	if(aeroportoTo.id > 0){
			 aeroportoTo.nome = (request.getParameter("nome") != null ? request.getParameter("nome") : "");
			 aeroportoTo.codigo = (request.getParameter("codigo") != null ? request.getParameter("codigo") : "");
			 aeroportoTo.nomeCompleto = (request.getParameter("nomeCompleto") != null ? request.getParameter("nomeCompleto") : "");
			 aeroportoTo.estado = (request.getParameter("estado") != null ? request.getParameter("estado") : "");
			 aeroportoTo.pais = (request.getParameter("pais") != null ? request.getParameter("pais") : "");
			 
			 
			 AeroportoTO resultado = aeroporto.alterar(aeroportoTo);
			 if(resultado != null){
				 request.setAttribute("succMsg", "alterado_sucesso");
				 view = "./ConsultarAeroporto?id="+resultado.id;
			 }else{
				 request.setAttribute("erroMsg", "alterar_erro");
				 request.setAttribute("aeroporto", aeroportoTo);
			 }
	 	}else{
	 		view = "./ListagemAeroporto";
	 	}
		request.getRequestDispatcher(view).forward(request, response);
		
	}
	
    @Override
	public void init(ServletConfig config){
		//todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}
	
}
