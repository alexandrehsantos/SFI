package br.alura.refatoracao.cap4;

abstract class ContaBancaria {
	
	protected String titular; 
	protected Double saldo;
	
	
	public ContaBancaria(String titular, Double saldo) {
		super();
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public void saca(double valor){
		this.saldo -= valor;
	}

	
	public void deposito(double valor){
		this.saldo += valor;
	}
	
	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	} 
	
	
	
	

}
