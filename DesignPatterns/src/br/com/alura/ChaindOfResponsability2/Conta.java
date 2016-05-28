package br.com.alura.ChaindOfResponsability2;

public class Conta {
	
	private String titular;
	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	private double saldo;

	public Conta (String titular, double saldo){
		this.titular = titular;
		this.saldo = saldo;
	}
	
	
	
}
