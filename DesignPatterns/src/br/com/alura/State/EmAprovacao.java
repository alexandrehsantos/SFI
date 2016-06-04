package br.com.alura.State;

public class EmAprovacao implements EstadoOrcamento {

	private boolean descontoAplicado;

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		if (!descontoAplicado) {
			orcamento.setValor(orcamento.getValor() - orcamento.getValor() * 0.05);
			descontoAplicado = true;
		}
		else {
			throw new RuntimeException("Desconto ja aplicado");
		}
	}

	@Override
	public void aprova(Orcamento orcamento) {
		orcamento.estadoOrcamento = new Aprovado();

	}

	@Override
	public void reprova(Orcamento orcamento) {
		orcamento.estadoOrcamento = new Reprovado();

	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException(
				"Este orcamento esta em fase de transicao e nao pode ser finalizado, apena aprovado ou reprovado");
	}

}
