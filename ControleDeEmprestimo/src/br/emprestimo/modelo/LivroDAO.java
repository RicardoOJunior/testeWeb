package br.emprestimo.modelo;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.emprestimo.servico.FabricaDeConexoes;

public class LivroDAO {
	Logger logger = Logger.getLogger(EmprestimoDAO.class);

	public int adiciona(Livro livro) {
		
		PreparedStatement ps;
		int codigoRetorno = 0;
		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps = (PreparedStatement) conn.prepareStatement(
					"insert into Livro (isbn, titulo, autor) values(?,?,?)");
			ps.setString(1, livro.getIsbn());
			ps.setString(2, livro.getTitulo());
			ps.setString(3, livro.getAutor());
			
			codigoRetorno = ps.executeUpdate();
			logger.info("codigo de retorno do metodo adiciona livro = " + codigoRetorno);

			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return codigoRetorno;
	}
	public int exclui (String isbn) {
		java.sql.PreparedStatement ps;
		int codigoretorno = 0;
		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps= conn.prepareStatement ("delete from Livro where isbn = ?");
			ps.setString(1, isbn);
			codigoretorno = ps.executeUpdate();
			}
		catch (SQLException e){
			throw new RuntimeException(e);
		}
	return codigoretorno;
	
	}
}