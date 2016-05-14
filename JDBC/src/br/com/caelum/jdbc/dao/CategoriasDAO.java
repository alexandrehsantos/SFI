package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Categoria;

public class CategoriasDAO {

	private final Connection con;

	public CategoriasDAO(Connection con) {
		this.con = con;
	}

	public List<Categoria> lista() throws SQLException {

		List<Categoria> categorias = new ArrayList<>();
		String sql = "select * from Categoria";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet resultSet = stmt.getResultSet()) {

				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String nome = resultSet.getString("nome");

					Categoria categoria = new Categoria(id, nome);

					categorias.add(categoria);
						
					}

				
				}

			}

	
	return categorias;
}

}
