package br.com.alura.decorator;

public class TesteImpostoDecorator {
	
	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento(1000);
		orcamento.adicionaItem(new Item("banana", 3.00));
		orcamento.adicionaItem(new Item("xxx", 300));
		orcamento.adicionaItem(new Item("yyyy", 700));
		orcamento.adicionaItem(new Item("zzzz", 1));
		
		
		Imposto icmsIss = new ICMS(new ISS());
		
		Imposto impostoMuitoAlto = new ImpostoMuitoAlto(new ICMS());
		
		System.out.println(icmsIss.calcula(orcamento));
		System.out.println(impostoMuitoAlto.calcula(orcamento));
	}
	
}
