package br.com.alura.TemplateMethod;

public class TesteImpostoTemplate {
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(1000.00);
		orcamento.adicionaItem(new Item("Cebola", 100));
		orcamento.adicionaItem(new Item("Batata", 300));

		Imposto icpp = new ICPP();
		Imposto ikvc = new IKVC();

		System.out.println(icpp.calcula(orcamento));
		System.out.println(ikvc.calcula(orcamento));
	}
}
