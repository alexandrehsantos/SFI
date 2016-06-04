package br.com.alura.State;

public class DescontoMaisCincoItens implements Desconto{

	
	
	private Desconto proximo;

	@Override
	public double calculaDesconto(Orcamento orcamento) {
		if(orcamento.getItens().size() > 5){
			return orcamento.getValor() * 0.1;
		}
		else {
			return proximo.calculaDesconto(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
