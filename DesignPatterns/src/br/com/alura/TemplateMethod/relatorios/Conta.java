package br.com.alura.TemplateMethod.relatorios;

public class Conta {
	private String nome;
	private double saldo;
	private int numero;
	public double getSaldo() {
		return saldo;
	}

	public int getNumero() {
		return numero;
	}

	public int getAgencia() {
		return agencia;
	}

	private int agencia;

	public Conta(String nome, double saldo, int numero, int agencia) {
		super();
		this.saldo = saldo;
		this.numero = numero;
		this.agencia = agencia;
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	} 
}
