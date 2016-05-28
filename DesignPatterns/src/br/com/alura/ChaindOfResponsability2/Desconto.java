package br.com.alura.ChaindOfResponsability2;

public interface Desconto {
	double calculaDesconto(Orcamento orcamento);
	void setProximo(Desconto proximo);
}
