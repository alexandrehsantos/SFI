package br.com.alura.State;

public class DescontoPorVendaCasada implements Desconto {

	private Desconto proximo;

	@Override
	public double calculaDesconto(Orcamento orcamento) {
		if (existe("Lapis", orcamento) && existe("Caneta", orcamento)) {
			return orcamento.getValor() * 0.05;
		} else {
			return proximo.calculaDesconto(orcamento);
		}

	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;

	}

	private boolean existe(String nomeDoItem, Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if (item.getNome().equalsIgnoreCase(nomeDoItem)) {

				return true;
			}
		}

		return false;
	}

}
