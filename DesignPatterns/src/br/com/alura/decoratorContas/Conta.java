package br.com.alura.decoratorContas;

import java.util.Calendar;

public class Conta {

	private String nome;
	private double saldo;
	private int agencia;
	private int numero;
	private Calendar dataAbertura;

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public Conta(String nome, double saldo, int agencia, int numero, Calendar date) {
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
	
	
}
