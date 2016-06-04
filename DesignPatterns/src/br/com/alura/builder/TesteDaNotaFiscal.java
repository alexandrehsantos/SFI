package br.com.alura.builder;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TesteDaNotaFiscal {
	public static void main(String[] args) {
		List<ItemDaNota> itens = Arrays.asList(new ItemDaNota("Item1", 100), new ItemDaNota("Item2", 500));
		double valorTotal = 0;
		
		for (ItemDaNota item : itens) {
			valorTotal += item.getValor();
		}
		 
		double impostos = valorTotal * 0.05;
		NotaFiscal nf = new NotaFiscal("Razao Social", "cnpj", Calendar.getInstance(), 1000, impostos, itens, "qualquer observacao");
		
		
		
		
	}
}
