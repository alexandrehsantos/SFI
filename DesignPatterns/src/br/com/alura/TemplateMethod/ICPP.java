package br.com.alura.TemplateMethod;

public class ICPP extends TemplateImpostoCondicional{


	
	@Override
	public boolean deveUsarAliquotaMaxima(Orcamento orcamento) {
		if(orcamento.getValor() > 500){
			return true;
		}
		return false;
	}

	@Override
	public double aliquotaMaxima(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	public double aliquotaMinima(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}


}
