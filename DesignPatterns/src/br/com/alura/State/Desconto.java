package br.com.alura.State;

public interface Desconto {
	double calculaDesconto(Orcamento orcamento);
	void setProximo(Desconto proximo);
}
