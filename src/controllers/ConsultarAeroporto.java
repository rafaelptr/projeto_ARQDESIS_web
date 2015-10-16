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
@WebServlet("/ConsultarAeroporto")
public class ConsultarAeroporto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarAeroporto() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = 0;
    	String Stringid = (request.getParameter("id") != null ? request.getParameter("id") : "0");
    	String view = "views/aeroporto/consultar.jsp";
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
	}
	
    @Override
	public void init(ServletConfig config){
		//todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}
}
