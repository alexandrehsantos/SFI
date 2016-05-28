package br.com.alura.ChaindOfResponsability;

public class TestaDescontos {
	
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(1000.00);
		orcamento.adicionaItem(new Item("Tablet", 200.00));
		orcamento.adicionaItem(new Item("Monitor", 300.00));
		
		Desconto desconto = new DescontoCincoItens();
		
		System.out.println(desconto.calcula(orcamento));
		System.out.println(orcamento.getValor());
		
	}



}
