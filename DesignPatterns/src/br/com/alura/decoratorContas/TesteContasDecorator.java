package br.com.alura.decoratorContas;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TesteContasDecorator {
	public static void main(String[] args) throws ParseException {

		Calendar c = Calendar.getInstance();
		c.set(1985, 06, 18);

		List<Conta> listaContas = new ArrayList<>();

		Conta conta = new Conta("Vaginildo", 20000, 123, 231321231, Calendar.getInstance());
		Conta conta1 = new Conta("Marieta", 1, 1234, 65465454, c);
		Conta conta2 = new Conta("Rubens", 2, 1234, 65465454, Calendar.getInstance());
		Conta conta3 = new Conta("xxx", 2333, 1234, 65465454, Calendar.getInstance());

		listaContas.add(conta);
		listaContas.add(conta1);
		listaContas.add(conta2);
		listaContas.add(conta3);

		Filtro filtro = new ContasSaldoMaiorQuinhetos(new ContasDataAberturaMesCorrente());

		List<Conta> filtrados = filtro.filtra(listaContas);

		for (Conta f : filtrados) {
			System.out.println(f.getNome());
		}

		
		
		
	}
}
