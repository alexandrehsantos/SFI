package br.com.alura.TemplateMethod;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HIT extends TemplateImpostoCondicional {

	@Override
	protected boolean deveUsarAliquotaMaxima(Orcamento orcamento) {
		Set<String> nomes = new HashSet<>();
		List<Item> itens = orcamento.getItens();
		for (Item item : itens) {
			nomes.add(item.getNome());
		}

		if (nomes.size() < itens.size()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected double aliquotaMaxima(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return orcamento.getValor() * 0.13 + 100;
	}

	@Override
	protected double aliquotaMinima(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return orcamento.getValor() * 0.01 + orcamento.getItens().size();
	}

}
