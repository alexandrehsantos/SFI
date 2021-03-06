package br.com.alura.TemplateMethod;

public abstract class TemplateImpostoCondicional extends Imposto{

	@Override
	public double calcula(Orcamento orcamento) {
		if(deveUsarAliquotaMaxima(orcamento)) {
			return aliquotaMaxima(orcamento);
		}
		return aliquotaMinima(orcamento);
	}
	
	protected abstract boolean deveUsarAliquotaMaxima(Orcamento orcamento);
	
	protected abstract double aliquotaMaxima(Orcamento orcamento);

	protected abstract double aliquotaMinima(Orcamento orcamento);
	
}
