package br.com.alura.decorator;

import java.util.List;

public class IKVC extends TemplateImpostoCondicional {

	public IKVC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IKVC(Imposto outrImposto) {
		super(outrImposto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean deveUsarAliquotaMaxima(Orcamento orcamento) {
		if (orcamento.getValor() > 500 && itemMaiorQueCem(orcamento)) {
			return true;
		}
		return false;
	}

	@Override
	public double aliquotaMaxima(Orcamento orcamento) {
		return orcamento.getValor() * 0.10;
	}

	@Override
	public double aliquotaMinima(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

	private boolean itemMaiorQueCem(Orcamento orcamento) {
		List<Item> itens = orcamento.getItens();

		for (Item item : itens) {
			if (item.getValor() > 100.00) {
				return true;
			}
		}

		return false;
	}
}
