package br.com.caelum.cap1ex.investimentos;

public class ImpostoPadrao implements ImpostosSobreInvestimentos {

	@Override
	public double calculaImposto(Investimento investimento) {

		return investimento.getRentabilidade() * 0.025;
	}

}
