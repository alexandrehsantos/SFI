package br.com.alura.State;

public class Aprovado implements EstadoOrcamento{

	private Orcamento orcamento;

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		
		
		if(this.orcamento==null){
			orcamento.setValor(orcamento.getValor() - orcamento.getValor() * 0.02);
			this.orcamento = orcamento;
		}
		else{
			throw new RuntimeException("Desconto já aplicado");
		}
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Este orcamento já econtra-se aprovado");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Nao eh possivel reprovar um orcamento ja aprovado");		
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estadoOrcamento = new Finalizado();
	}


}
