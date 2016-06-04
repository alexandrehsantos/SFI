package br.com.alura.builderExercicio;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TesteNotaFiscal {
	public static void main(String[] args) {

		List<ItemDaNota> itens = Arrays.asList(new ItemDaNota("item 1", 200), new ItemDaNota("item2", 500));

		double valorBruto = 0;
		double impostos = 0;
		for (ItemDaNota item : itens) {
			valorBruto += item.getValor();
			impostos += item.getValor() * 0.05;
		}

		NotaFiscal nf = new NotaFiscal("Alguma Empresa ", "123456", valorBruto, impostos, Calendar.getInstance(), "xxxxxxxxxxxxx",
				itens);
		
		System.out.println(nf.getValorBruto());
		System.out.println(nf.getImpostos());
		
		
		
		
		
		
		
		
	}
}
