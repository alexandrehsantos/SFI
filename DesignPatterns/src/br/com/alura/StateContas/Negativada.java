package br.com.alura.StateContas;

public class Negativada implements EstadoConta{

	@Override
	public void saca(Conta conta, double valor) {
		
		throw new RuntimeException("Não é possível sacar quando o saldo está negativo.");
		
	}

	@Override
	public void deposita(Conta conta, double valor) {
		conta.saldo += valor * 0.95;
		if(conta.saldo>0) conta.estadoConta = new Positivada();
	}

}
