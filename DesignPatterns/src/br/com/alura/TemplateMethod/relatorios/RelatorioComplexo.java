package br.com.alura.TemplateMethod.relatorios;

import java.util.List;

public class RelatorioComplexo extends Relatorio{

	@Override
	protected void cabecalho() {
		System.out.println("Banco Santander");
		System.out.println("Rua Turiassu");
		System.out.println("(11) 9999-99999");
	}

	@Override
	protected void rodape() {
		System.out.println("santander@bancos.com.br");
		System.out.println("01/01/0001");
	}

	@Override
	protected void corpo(List<Conta> contas) {
		// TODO Auto-generated method stub
		for (Conta conta : contas) {
			System.out.println(conta.getNome());
			System.out.println(conta.getAgencia());
			System.out.println(conta.getNumero());
			System.out.println(conta.getSaldo());
		}
	}

}
