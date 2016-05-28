package br.com.caelum.cap1ex.investimentos;

public class Conservador extends Investimento {

	@Override
	public double calcula(Conta conta) {
		rentabilidade = conta.getSaldo() * 0.008;
		
		return rentabilidade;
	}

	public double getRentabilidade() {
		return rentabilidade;
	}
}
