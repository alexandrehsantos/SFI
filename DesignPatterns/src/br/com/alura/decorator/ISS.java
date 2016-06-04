package br.com.alura.decorator;

public class ISS extends Imposto {
	
	public ISS() {
		super();
	}

	public ISS(Imposto outrImposto) {
		super(outrImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}
}
