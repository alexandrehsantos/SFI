package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.dao.CategoriasDAO;
import br.com.caelum.jdbc.dao.ProdutosDAO;
import br.com.caelum.jdbc.modelo.Categoria;
import br.com.caelum.jdbc.modelo.Produto;

public class TestaCategoria {
	public static void main(String[] args) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			List<Categoria> categorias = new CategoriasDAO(con).listaComProdutos();

			for (Categoria categoria : categorias) {
				System.out.println(categoria.getNome());

				for (Produto produto : categoria.getProduto()) {
					System.out.println(categoria.getNome() + " - " + produto.getNome());
				}

			}

			List<Categoria> categorias2 = new CategoriasDAO(con).listaComProdutos();

			for (Categoria categoria : categorias2) {
				System.out.println(categoria.getNome());

			}
		}
	}
}
