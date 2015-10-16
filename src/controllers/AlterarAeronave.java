package controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aeronave;
import to.AeronaveTO;

/**
 * Servlet implementation class AeronaveController
 */
@WebServlet("/AlterarAeronave")
public class AlterarAeronave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarAeronave() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = 0;
    	String Stringid = (request.getParameter("id") != null ? request.getParameter("id") : "0");
    	String view = "views/aeronave/alterar.jsp";
    	try{
    		id = Integer.parseInt(Stringid);
    	}catch(NumberFormatException e) {
    		request.setAttribute("erroMsg", "dados_invalidos_erro");
    		view = "./ListagemAeronave";
    	}
    	if(id > 0){
    		Aeronave aeronave = new Aeronave();
    		AeronaveTO to = aeronave.buscarId(id);
    		request.setAttribute("aeronave", to);
    	}
    	request.getRequestDispatcher(view).forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Aeronave aeronave = new Aeronave();
         AeronaveTO aeronaveTo = new AeronaveTO();			 
	 	 String view = "views/aeronave/alterar.jsp";
    	String Stringid = (request.getParameter("id") != null ? request.getParameter("id") : "0");
    	try{
    		aeronaveTo.id = Integer.parseInt(Stringid);
    	}catch(NumberFormatException e) {
    		request.setAttribute("erroMsg", "dados_invalidos_erro");
    		view = "./ListagemAeronave";
    	}
    	if(aeronaveTo.id > 0){
	         aeronaveTo.codigo = (request.getParameter("codigo") != null ? request.getParameter("codigo") : "");
			 aeronaveTo.nome = (request.getParameter("nome") != null ? request.getParameter("nome") : "");
			 aeronaveTo.qtdAssentosA = Integer.parseInt((request.getParameter("qtd_assentos_A") != null ? request.getParameter("qtd_assentos_A") : "0"));
			 aeronaveTo.qtdAssentosB = Integer.parseInt((request.getParameter("qtd_assentos_B") != null ? request.getParameter("qtd_assentos_B") : "0"));
			 aeronaveTo.qtdAssentosC = Integer.parseInt((request.getParameter("qtd_assentos_C") != null ? request.getParameter("qtd_assentos_C") : "0"));
			 aeronaveTo.qtdAssentosHorizontais = Integer.parseInt((request.getParameter("qtd_assentos_horizontais") != null ? request.getParameter("qtd_assentos_horizontais") : "0"));
			 aeronaveTo.qtdAssentosVerticais = Integer.parseInt((request.getParameter("qtd_assentos_verticais") != null ? request.getParameter("qtd_assentos_verticais") : "0"));
			 
			 AeronaveTO resultado = aeronave.alterar(aeronaveTo);
			 if(resultado != null){
				 request.setAttribute("succMsg", "alterado_sucesso");
				 view = "./ConsultarAeronave?id="+resultado.id;
			 }else{
				 request.setAttribute("erroMsg", "alterar_erro");
				 request.setAttribute("aeronave", aeronaveTo);
			 }
	 	}else{
	 		view = "./ListagemAeronave";
	 	}
		request.getRequestDispatcher(view).forward(request, response);
		
	}
	
    @Override
	public void init(ServletConfig config){
		//todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}
	
}
