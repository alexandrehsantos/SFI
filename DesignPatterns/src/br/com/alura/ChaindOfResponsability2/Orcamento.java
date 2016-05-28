package br.com.alura.ChaindOfResponsability2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orcamento {

	private double valor;
	private List<Item> itens;

	public Orcamento(double valor) {
		this.valor = valor;
		itens = new ArrayList<>();
	}
	
	public double getValor() {
		return valor;
	}


	
	public void adicionaItem(Item item){
		itens.add(item);
	}


	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}


	
}
