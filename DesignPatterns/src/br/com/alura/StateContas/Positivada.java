package br.com.alura.StateContas;

public class Positivada implements EstadoConta {

	@Override
	public void saca(Conta conta, double valor) {
		conta.saldo -= valor;
		if(conta.saldo <0) conta.estadoConta = new Negativada();
	}

	@Override
	public void deposita(Conta conta, double valor) {
		conta.saldo += valor * 0.98;
	}

}
