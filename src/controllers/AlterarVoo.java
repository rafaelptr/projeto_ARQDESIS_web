package controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import languages.Idioma;
import model.Aeronave;
import model.Aeroporto;
import model.Voo;
import to.VooTO;

/**
 * Servlet implementation class VooController
 */
@WebServlet("/AlterarVoo")
public class AlterarVoo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarVoo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = 0;
    	String Stringid = (request.getParameter("id") != null ? request.getParameter("id") : "0");
    	String view = "views/voo/alterar.jsp";
    	try{
    		id = Integer.parseInt(Stringid);
    	}catch(NumberFormatException e) {
    		request.setAttribute("erroMsg", "dados_invalidos_erro");
    		view = "./ListagemVoo";
    	}
    	if(id > 0){
    		Voo voo = new Voo();
    		VooTO to = voo.buscarId(id);
    		request.setAttribute("voo", to);
    	}

    	Aeronave aeronave = new Aeronave();
    	Aeroporto aeroporto = new Aeroporto();
    	request.setAttribute("aeronaves", aeronave.listagem());
    	request.setAttribute("aeroportos", aeroporto.listagem());
    	request.getRequestDispatcher(view).forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Voo voo = new Voo();
         VooTO vooTo = new VooTO();			 
	 	 String view = "views/voo/alterar.jsp";
    	String Stringid = (request.getParameter("id") != null ? request.getParameter("id") : "0");
    	try{
    		vooTo.id = Integer.parseInt(Stringid);
    	}catch(NumberFormatException e) {
    		request.setAttribute("erroMsg", "dados_invalidos_erro");
    		view = "./ListagemVoo";
    	}
    	if(vooTo.id > 0){
   		 	boolean valido = false;
      		 vooTo.nome = (request.getParameter("nome") != null ? request.getParameter("nome") : "");
   			 vooTo.codigo = (request.getParameter("codigo") != null ? request.getParameter("codigo") : "");
   			 try{
   				 String dataString = (request.getParameter("data") != null ? request.getParameter("data") : "");
   				 DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
   				 vooTo.data = (Date)formatter.parse(dataString);
   			 }catch(Exception e){
   				 request.setAttribute("erroMsg", "data_invalida_erro");
   				 vooTo.data = null;
   			 }
   			 
   			 try{
   				 String precoString = (request.getParameter("preco") != null ? request.getParameter("preco") : "");
   				 if(precoString.indexOf(",") != -1 ){
   					 precoString = precoString.replace(",", ".");
   				 }
   				 double preco = Double.parseDouble(precoString);
   				 precoString = String.format("%.2f", preco);
   				 if(precoString.indexOf(",") != -1 ){
   					 precoString = precoString.replace(",", ".");
   				 }
   				 preco = Double.parseDouble(precoString);
   				 vooTo.preco = preco;				 
   			 }catch(Exception e){
   				 request.setAttribute("erroMsg", "preco_invalido_erro");
   				 vooTo.preco = 0.0;
   			 }
   			 
   			 try{
   				 String aeronaveId = (request.getParameter("aeronaveId") != null ? request.getParameter("aeronaveId") : "");
   				 vooTo.aeronaveId = Integer.parseInt(aeronaveId);
   			 }catch(Exception e){
   				 request.setAttribute("erroMsg", "selecione_aeronave_erro");
   				 vooTo.aeronaveId = 0;
   			 }
   			 
   			 try{
   				 String aeroportoDestinoId = (request.getParameter("aeroportoDestinoId") != null ? request.getParameter("aeroportoDestinoId") : "");
   				 vooTo.aeroportoDestinoId = Integer.parseInt(aeroportoDestinoId);
   			 }catch(Exception e){
   				 request.setAttribute("erroMsg", "selecione_aeroportoDestinoId_erro");
   				 vooTo.aeroportoDestinoId = 0;
   			 }
   			 
   			 try{
   				 String aeroportoOrigemId = (request.getParameter("aeroportoOrigemId") != null ? request.getParameter("aeroportoOrigemId") : "");
   				 vooTo.aeroportoOrigemId = Integer.parseInt(aeroportoOrigemId);
   			 }catch(Exception e){
   				 request.setAttribute("erroMsg", "selecione_aeroportoOrigemId_erro");
   				 vooTo.aeroportoOrigemId = 0;
   			 }
   			 
   			 if(vooTo.aeronaveId > 0 && vooTo.aeroportoDestinoId > 0 && vooTo.aeroportoOrigemId > 0 && vooTo.data != null && vooTo.preco > 0.0 ){
   				 valido = true;
   			 }
   			 
   			 if(valido){
   				 VooTO resultado = voo.alterar(vooTo);
   				 if(resultado != null){
   					 request.setAttribute("succMsg", "alterado_sucesso");
   					 view = "./ConsultarVoo?id="+resultado.id;
   				 }else{
   					 request.setAttribute("erroMsg", "alterar_erro");
   					 request.setAttribute("voo", vooTo);
   				 }
   			 }
	 	}else{
	 		view = "./ListagemVoo";
	 	}

    	Aeronave aeronave = new Aeronave();
    	Aeroporto aeroporto = new Aeroporto();
    	request.setAttribute("voo", vooTo);
    	request.setAttribute("aeronaves", aeronave.listagem());
    	request.setAttribute("aeroportos", aeroporto.listagem());
		request.getRequestDispatcher(view).forward(request, response);
		
	}
	
    @Override
	public void init(ServletConfig config){
		//todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}
	
}
