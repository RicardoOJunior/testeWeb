package br.emprestimo.controle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletControle
 */
@WebServlet("/ServletControle")
public class ServletControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String,ICommand> cmds = new HashMap<String,ICommand>();

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
    	cmds.put("/FormEmpresa", new Cmd_RegistrarEmprestimo());
    	//cmds.put("IncluirLivro", new Cmd_IncluirLivro());
    	//cmds.put("ExcluirLivro", new Cmd_ExcluirLivro());
   	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
