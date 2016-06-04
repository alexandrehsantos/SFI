package br.com.alura.decorator;

public abstract class TemplateImpostoCondicional extends Imposto{

	public TemplateImpostoCondicional() {
		super();
	}

	public TemplateImpostoCondicional(Imposto outrImposto) {
		super(outrImposto);
	}

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
