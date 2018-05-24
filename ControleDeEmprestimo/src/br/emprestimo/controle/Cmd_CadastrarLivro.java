package br.emprestimo.controle;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import br.emprestimo.modelo.Livro;


public class Cmd_CadastrarLivro implements ICommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = null;
		Logger logger = Logger.getLogger("Cmd_CadastrarLivro");
		logger.info("chamou o comando cadastrar livro");
		int rc =0; //codigo de retorno da inclusao no DB
		Livro livro = new Livro();
		try {
			livro.setIsbn(request.getParameter("txtIsbn"));
			livro.setTitulo(request.getParameter("txtTitulo"));
			livro.setAutor(request.getParameter("txtAutor"));
			if (rc == 1) {
				msg = "cadastro realizado com sucesso";
			}else{
				msg = "dados invalidos";
			}
			request.setAttribute("msg", msg);
			RequestDispatcher view = request.getRequestDispatcher("FormLivro.jsp");
	        view.forward(request, response); 
		} catch (Exception e) {
			msg = e.getMessage();
			logger.info("erro  = " + e.getMessage());
	        request.setAttribute("msg", msg);
	        RequestDispatcher view = request.getRequestDispatcher("FormLivro.jsp");;
	        view.forward(request, response); 
			
		}
		
	}

}
