package br.com.caelum.cap1ex.investimentos;

public class Moderado extends Investimento{
	
	@Override
	public double calcula(Conta conta) {
		
		
		if(new java.util.Random().nextDouble() > 0.50){
			rentabilidade = conta.getSaldo() * 0.025 ;
			return rentabilidade;
		} else {
			rentabilidade = conta.getSaldo() * 0.007;
			return rentabilidade;
		}
	}
	
	
	public double getRentabilidade() {
		return rentabilidade;
	}

}
