package br.com.caelum.cap1ex.investimentos;

public class TesteInvestimentos {
	public static void main(String[] args) {
		Conta conta = new Conta(300.00);
		Investimento investimento = new Arrojado();
		ImpostosSobreInvestimentos impostosSobreInvestimentos = new ImpostoPadrao();
		
		RealizadorDeInvestimentos investir = new RealizadorDeInvestimentos();
		investir.investe(conta, investimento, impostosSobreInvestimentos);
		
		System.out.println(conta.getSaldo());
		System.out.println("Valor Bruto: " + investir.getIvestimentoBruto(investimento, impostosSobreInvestimentos));
		
	}
}
