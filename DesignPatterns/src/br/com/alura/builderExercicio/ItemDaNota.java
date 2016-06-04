package br.com.alura.builderExercicio;

public class ItemDaNota {
	private String descricao;
	private double valor;
	
	public String getDescricao() {
		return descricao;
	}
	public double getValor() {
		return valor;
	}
	public ItemDaNota(String descricao, double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}
	
}
