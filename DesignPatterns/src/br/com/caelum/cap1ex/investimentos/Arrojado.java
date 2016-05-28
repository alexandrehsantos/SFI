package br.com.caelum.cap1ex.investimentos;

public class Arrojado extends Investimento{

	
	@Override
	public double calcula(Conta conta) {
		
		if (new java.util.Random().nextDouble() > 0.30) {
			rentabilidade = conta.getSaldo() * 0.03;
			return rentabilidade;
		}
		else if (new java.util.Random().nextDouble() > 0.50) {
			rentabilidade = conta.getSaldo() * 0.06;
			return rentabilidade;
		}
		
		rentabilidade = conta.getSaldo() * 0.05 ;
		return rentabilidade;
	}

}
