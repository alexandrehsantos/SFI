package br.alura.refatoracao.cap6;

public enum Moeda {

	DOLAR(2.7),
	REAL(1.0);
	
	private double taxa; 
	
	Moeda(double taxa){
		this.taxa = taxa;
	}
	
	
	public double getTaxa(){
		return taxa;
	}
	
	
}
