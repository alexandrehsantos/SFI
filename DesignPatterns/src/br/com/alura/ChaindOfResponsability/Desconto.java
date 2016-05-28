package br.com.alura.ChaindOfResponsability;

public interface Desconto {

	
	double calcula(Orcamento orcamento); 
	
	void proximoDesconto(Desconto desconto);
	
	
}
