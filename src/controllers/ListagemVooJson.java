package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Voo;
import to.ListagemVooTO;

/**
 * Servlet implementation class VooController
 */
@WebServlet("/ListagemVooJson")
public class ListagemVooJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListagemVooJson() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Voo voo = new Voo();
    	ListagemVooTO listagem = voo.listagem();
    	response.setCharacterEncoding("UTF-8");
    	/*
		 * Para enviar para uma aplicacao
		 * Descomente o trecho demarcado por <app></app> e comente o trecho demarcado por <download></download>

		 * Para enviar para download via browser
		 * Descomente o trecho demarcado por <download></download> e comente o trecho demarcado por <app></app>
		 * 
		 * */
		//<app>
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();		
		out.println(listagem.toJSON());
		//</app>

		//<download>
//		response.setContentType("application/octet-stream");
//		response.setHeader("Content-disposition","attachment; filename=chamados.json");
//		OutputStream out = response.getOutputStream();
//		out.write(lista.toJSON().getBytes());
//		out.flush();
		//</download>
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
	}

    @Override
	public void init(ServletConfig config){
		//todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}
	
}
