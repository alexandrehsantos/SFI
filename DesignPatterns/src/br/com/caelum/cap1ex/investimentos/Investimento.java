package br.com.caelum.cap1ex.investimentos;

abstract class Investimento {

	protected double rentabilidade; 
	
	abstract double calcula(Conta conta);

	public double getRentabilidade() {
		return rentabilidade;
	}

}
