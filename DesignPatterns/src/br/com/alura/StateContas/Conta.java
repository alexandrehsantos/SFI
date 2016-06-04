package br.com.alura.StateContas;

import java.util.Calendar;

public class Conta {

	private String nome;
	protected double saldo;
	private int agencia;
	private int numero;
	private Calendar dataAbertura;
	public EstadoConta estadoConta;

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	
	public Conta(String nome, double saldo, int agencia, int numero, Calendar date) {
		estadoConta = new Positivada();
		this.nome = nome;
		this.saldo = saldo;
		this.agencia = agencia;
		this.numero = numero;
		this.dataAbertura = date;
	}
	
	

	public String getNome() {
		return nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}
	
	public void deposita(double valor){
		estadoConta.deposita(this, valor);
	}
	
	public void saca(double valor){
		estadoConta.saca(this, valor);
	}
	
}
