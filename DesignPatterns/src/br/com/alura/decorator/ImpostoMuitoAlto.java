package br.com.alura.decorator;

public class ImpostoMuitoAlto extends Imposto{

	public ImpostoMuitoAlto() {
		super();
	}
	
	public ImpostoMuitoAlto(Imposto outroImposto){
		super(outroImposto);
	}
	
	@Override
	protected double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.20 + calculaOutroImposto(orcamento);
	}

}
