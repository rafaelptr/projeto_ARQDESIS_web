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
@WebServlet("/CadastrarAeroporto")
public class CadastrarAeroporto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarAeroporto() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("views/aeroporto/cadastrar.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Aeroporto aeroporto = new Aeroporto();
    	 AeroportoTO aeroportoTo = new AeroportoTO();			 
	 	 String view = "views/aeroporto/cadastrar.jsp";
         
		 aeroportoTo.nomeCompleto = (request.getParameter("nomeCompleto") != null ? request.getParameter("nomeCompleto") : "");
		 aeroportoTo.codigo = (request.getParameter("codigo") != null ? request.getParameter("codigo") : "");
		 aeroportoTo.nome = (request.getParameter("nome") != null ? request.getParameter("nome") : "");
		 aeroportoTo.estado = (request.getParameter("estado") != null ? request.getParameter("estado") : "");
		 aeroportoTo.pais = (request.getParameter("pais") != null ? request.getParameter("pais") : "");
		 
		 AeroportoTO resultado = aeroporto.incluir(aeroportoTo);
		 if(resultado.id > 0){
			 request.setAttribute("succMsg", "cadastrado_sucesso");
			 view = "./ConsultarAeroporto?id="+resultado.id;
		 }else{
			 request.setAttribute("erroMsg", "cadastro_erro");
			 request.setAttribute("aeroporto", aeroportoTo);
		 }
		request.getRequestDispatcher(view).forward(request, response);
	}
	

    @Override
	public void init(ServletConfig config){
		//todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}
	
}
