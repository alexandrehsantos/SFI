package br.com.alura.TemplateMethod;

public abstract class Imposto {

	private Imposto outroImposto;

	public Imposto(Imposto outroImposto) {
		super();
		this.outroImposto = outroImposto;
	}

	public Imposto() {
		outroImposto = null;
	}

	protected abstract double calcula(Orcamento orcamento);

	protected double calculaOutroImposto(Orcamento orcamento) {
		if (outroImposto == null) {
			return 0;
		}

		return outroImposto.calcula(orcamento);
	}
}
