package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import languages.Idioma;
import model.Usuario;
import to.UsuarioTO;
import utils.DadosSessao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		String acao = (String)(req.getParameter("acao")== null ? "" : req.getParameter("acao"));
		boolean logado = DadosSessao.logado(req);
		if(acao.toLowerCase().equals("logoff")){
			req.getSession().setAttribute("logado", false);
			req.getSession().setAttribute("usuarioLogado", null);
			rd = req.getRequestDispatcher("views/login/login.jsp");
		}else if (!logado){
			rd = req.getRequestDispatcher("views/login/login.jsp");
		}else{
			rd = req.getRequestDispatcher("./");
		}

		rd.forward(req, resp);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UsuarioTO usuarioTo = new UsuarioTO();
		usuarioTo.usuario = (String)(request.getParameter("usuario") != null?request.getParameter("usuario"):"");
		usuarioTo.senha = (String)(request.getParameter("senha") != null?request.getParameter("senha"):"");

		
		Usuario usuario = new Usuario();
		UsuarioTO usuarioBanco = usuario.buscar(usuarioTo);
		RequestDispatcher rd = null;
		if(usuarioBanco != null){
			request.getSession().setAttribute("logado", true);
			request.getSession().setAttribute("usuarioLogado", usuarioTo);
			rd = request.getRequestDispatcher("./");
			
		}else{
			request.getSession().setAttribute("logado", false);
			request.getSession().setAttribute("usuarioLogado", null);
			request.setAttribute("ErrorMsg",Idioma.para(request, "usuario_senha_invalidos"));
			rd = request.getRequestDispatcher("views/login/login.jsp");
		}
		rd.forward(request, response);
	}


    @Override
	public void init(ServletConfig config){
		//todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}
}
