package br.com.caelum.jdbc.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.ConnectionPool;
import br.com.caelum.jdbc.dao.CategoriasDAO;
import br.com.caelum.jdbc.dao.ProdutosDAO;

public class TestaCategoria {
	public static void main(String[] args) throws SQLException {
			try(Connection con = new ConnectionPool().getConnection()){
				List<Categoria> categorias = new CategoriasDAO(con).lista();
				
					for (Categoria categoria : categorias) {
						System.out.println(categoria.getNome());

							for (Produto produto : new ProdutosDAO(con).busca(categoria)) {
								System.out.println(categoria.getNome() + " - "+  produto.getNome());
							}
						
					}
			}
	}
}