package br.com.alura.decorator;

public class TesteDeImpostos {
	public static void main(String[] args) {
		Imposto iss = new ISS(); 
		Imposto icms = new ICMS();
		
		Orcamento orcamento = new Orcamento(500.0);
		
		
		CalculadoraDeImpostos calculadoraDeImpostos = new CalculadoraDeImpostos();
		
		calculadoraDeImpostos.realizaCauculo(orcamento, iss);
		calculadoraDeImpostos.realizaCauculo(orcamento, icms);
	}
}
