package br.com.caelum.cap1ex.investimentos;

public class RealizadorDeInvestimentos {

	public void investe(Conta conta, Investimento investimento, ImpostosSobreInvestimentos impostosSobreInvestimentos) {

		investimento.calcula(conta);

		conta.deposita(impostosSobreInvestimentos.calculaImposto(investimento));

	}

	public double getIvestimentoBruto(Investimento investimento, ImpostosSobreInvestimentos impostosSobreInvestimentos){
		return investimento.getRentabilidade()  - impostosSobreInvestimentos.calculaImposto(investimento);
		 
	}
}
