package br.com.caelum.jdbc.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.ConnectionPool;
import br.com.caelum.jdbc.dao.ProdutosDAO;

public class TestaDAODeProduto {

	public static void main(String[] args) throws SQLException {
		Produto mesa = new Produto("Mesa Marron", "mesa com 4 pes");

		try (Connection con = new ConnectionPool().getConnection()) {
		ProdutosDAO dao = new ProdutosDAO(con);
		dao.salva(mesa);
		
	   List <Produto> produtos	= dao.lista();
		for (Produto produto : produtos) {
			System.out.println("Existe o produto: " + produto);
		}
		}

		
	}



}
