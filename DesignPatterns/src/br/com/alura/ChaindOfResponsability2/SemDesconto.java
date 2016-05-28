package br.com.alura.ChaindOfResponsability2;

public class SemDesconto implements Desconto{

	@Override
	public double calculaDesconto(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto proximo) {
		
	}

}
