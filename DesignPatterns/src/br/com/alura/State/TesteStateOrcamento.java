package br.com.alura.State;

public class TesteStateOrcamento {

	public static void main(String[] args) {

		Orcamento orcamento = new Orcamento(1000);

		System.out.println(orcamento.getValor());

		orcamento.aplicaDesconto();

		System.out.println(orcamento.getValor());

		orcamento.aprova();

		System.out.println(orcamento.getValor());
		
		orcamento.aplicaDesconto();
		
		
		System.out.println(orcamento.getValor());
		
		

		
		
		
		
	}
}
