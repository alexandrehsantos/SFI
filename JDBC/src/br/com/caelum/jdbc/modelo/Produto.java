package br.com.caelum.jdbc.modelo;

public class Produto {

	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	String nome;
	String descricao;
	Integer id; 
	
	
	@Override
	public String toString() {
		return String.format("[produto: %d %s %s]", id, nome, descricao);
	}
	

}
