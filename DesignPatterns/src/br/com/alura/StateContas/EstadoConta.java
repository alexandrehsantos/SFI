package br.com.alura.StateContas;

public interface EstadoConta {

	void saca(Conta conta, double valor);
	void deposita(Conta conta, double valor);
	
}
