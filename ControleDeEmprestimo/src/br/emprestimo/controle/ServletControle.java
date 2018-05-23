package br.emprestimo.controle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ServletControle
 */
@WebServlet("/ServletControle")
public class ServletControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final WebsiteTitle myapp = new WebsiteTitle();
	private Map<String,ICommand> cmds = new HashMap<String,ICommand>();
	Logger logger = Logger.getLogger("ServletControle");

    /**
     * Default constructor. 
     */
    public ServletControle() {
        // TODO Auto-generated constructor stub
    }
    /**
     * instancia os comandos
     */
    private void initCommands() {
    	cmds.put("/home", new Home());
    	cmds.put("/FormLivro", new Cmd_RegistrarEmprestimo());
    	//cmds.put("IncluirLivro", new Cmd_IncluirLivro());
    	//cmds.put("ExcluirLivro", new Cmd_ExcluirLivro());
   	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		String parametro = request.getParameter("acao");
		ICommand acao = null;
		logger.info(path);
		logger.info(parametro);
		       
        request.setAttribute("myapp", myapp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
