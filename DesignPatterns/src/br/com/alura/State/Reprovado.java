package br.com.alura.State;

public class Reprovado implements EstadoOrcamento {

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		
	}

	@Override
	public void aprova(Orcamento orcamento) {

		throw new RuntimeException("O orcamento já reprovado e nao pode ser aprovado novamente"); 
	}

	@Override
	public void reprova(Orcamento orcamento) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Orcamento já está reprovado");

	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estadoOrcamento.finaliza(orcamento);
	}

}
