package br.com.caelum.cap1ex.investimentos;

public class Conta {

	private double saldo;

	
	
	
	public Conta(double valor) {
	this.saldo = + valor;
	}

	public double getSaldo() {
		return saldo;
	}

	public void deposita(double saldo) {
		this.saldo += saldo;
	}
	
	
	public void saca(double valor){
		this.saldo -= valor;
	}

}
