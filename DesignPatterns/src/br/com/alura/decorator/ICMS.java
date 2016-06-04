package br.com.alura.decorator;

public class ICMS extends Imposto {
	public ICMS() {
		super();// TODO Auto-generated constructor stub
	}

	public ICMS(Imposto outroImposto) {
		super(outroImposto);// TODO Auto-generated constructor stub
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.1 + calculaOutroImposto(orcamento);
	}
}
