package br.com.alura.builderExercicio;

public class BuildItemNota {
	private String descricao;
	private double valor;

	public BuildItemNota comDescricao (String descricao){
		this.descricao = descricao;
		return this;
	}
	public BuildItemNota comValor(double valor){
		this.valor = valor;
		return this;
	}
	public ItemDaNota build(){
		ItemDaNota item = new ItemDaNota(descricao, valor);
		return item;
	}
}
