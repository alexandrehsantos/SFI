package br.com.alura.ChaindOfResponsability2;

public class TestaDescontos {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(300);
		orcamento.adicionaItem(new Item(100, "Lapis"));
		orcamento.adicionaItem(new Item(380, "caneta"));
		orcamento.adicionaItem(new Item(30, "yyyyyyy"));
		orcamento.adicionaItem(new Item(80, "yyyyyyy"));
		orcamento.adicionaItem(new Item(380, "abcdef"));
		
		Desconto d1 = new DescontoMaisCincoItens();
		Desconto d2 = new DescontoMaisDeQuinhentosReais();
		Desconto d3 = new DescontoPorVendaCasada();
		Desconto d4 = new SemDesconto();
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);

		System.out.println(d1.calculaDesconto(orcamento));
	
	}
	
}
