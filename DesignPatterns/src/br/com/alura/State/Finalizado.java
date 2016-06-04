package br.com.alura.State;

public class Finalizado implements EstadoOrcamento{

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Nao eh possivel aprovar um orcamento ja finalizado");// TODO Auto-generated method stub
		
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Nao eh possivel reprovar um orcamento ja finalizado");
		
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Este orcamento ja encontra-se finalizado");
		
	}

}
