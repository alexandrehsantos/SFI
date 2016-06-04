package br.com.alura.decorator;

public class ICPP extends TemplateImpostoCondicional{
	
	public ICPP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ICPP(Imposto outrImposto) {
		super(outrImposto);
		// TODO Auto-generated constructor stub
	}

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
