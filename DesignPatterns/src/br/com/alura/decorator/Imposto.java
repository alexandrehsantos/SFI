package br.com.alura.decorator;

public abstract class Imposto {

	private Imposto outroImposto;

	public Imposto(Imposto outrImposto) {
		this.outroImposto = outrImposto;
	}

	public Imposto() {
		this.outroImposto = null;// TODO Auto-generated constructor stub
	}

	protected abstract double calcula(Orcamento orcamento);

	protected double calculaOutroImposto(Orcamento orcamento) {
		return ((outroImposto != null) ? outroImposto.calcula(orcamento) : 0);
	}
}
