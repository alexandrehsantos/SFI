package br.com.alura.TemplateMethod;
public class CalculadoraDeImpostos {

	public void realizaCauculo(Orcamento orcamento, Imposto impostoQualquer){
		
		double icms = impostoQualquer.calcula(orcamento);
		System.out.println(icms);
		
	}
	
	
}
