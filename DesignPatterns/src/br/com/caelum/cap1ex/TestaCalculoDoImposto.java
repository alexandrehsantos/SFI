package br.com.caelum.cap1ex;

public class TestaCalculoDoImposto {
	public static void main(String[] args) {

		Imposto iss = new ISS();
		Imposto icms = new ICMS();
		Imposto iccc = new ICCC();
		
		Orcamento orcamento = new Orcamento(30001.00);

		CalculadorDeImposto calculadorDeImposto = new CalculadorDeImposto();

		System.out.println(calculadorDeImposto.calcula(orcamento, iss));
		System.out.println(calculadorDeImposto.calcula(orcamento, icms));
		System.out.println(calculadorDeImposto.calcula(orcamento, iccc));
	}
}
