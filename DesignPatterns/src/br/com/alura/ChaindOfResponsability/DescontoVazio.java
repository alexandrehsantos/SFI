package br.com.alura.ChaindOfResponsability;

public class DescontoVazio implements Desconto {

	@Override
	public double calcula(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void proximoDesconto(Desconto desconto) {
		// TODO Auto-generated method stub

	}

}
