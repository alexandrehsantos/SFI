package br.com.caelum.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private final Integer id;
	private final String nome;
	private final List<Produto> produtos = new ArrayList<>();

	public Categoria(Integer id, String nome) {
		
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void adiciona(Produto p) {
		this.produtos.add(p);
		
	}

	public List<Produto> getProduto() {
		// TODO Auto-generated method stub
		return produtos;
	}
	
	

}
