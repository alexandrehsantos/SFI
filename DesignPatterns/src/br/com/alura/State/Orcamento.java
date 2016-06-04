package br.com.alura.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orcamento {

	private double valor;
	private List<Item> itens;
	protected EstadoOrcamento estadoOrcamento;

	public Orcamento(double valor) {
		this.setValor(valor);
		itens = new ArrayList<>();
		this.estadoOrcamento = new EmAprovacao();
	}
	
	public Orcamento(){
		this.estadoOrcamento = new EmAprovacao();
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


	public void aplicaDesconto(){
		estadoOrcamento.aplicaDescontoExtra(this);
	}
	
	public void aprova(){
		estadoOrcamento.aprova(this);
	}
	
	public void reprova(){
		estadoOrcamento.reprova(this);
	}
	
	public void finaliza(){
		estadoOrcamento.finaliza(this);
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
