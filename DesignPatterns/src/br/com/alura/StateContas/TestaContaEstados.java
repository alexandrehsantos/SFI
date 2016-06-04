package br.com.alura.StateContas;

import java.util.Calendar;

public class TestaContaEstados {
	public static void main(String[] args) {

		Conta conta = new Conta("Alexandre Santos", 1000, 1234, 500158, Calendar.getInstance());
		conta.deposita(500);

		System.out.println(conta.getSaldo());

		conta.deposita(100);

		System.out.println(conta.getSaldo());

		conta.saca(3000);

		System.out.println(conta.getSaldo());

		conta.deposita(100);

		System.out.println(conta.getSaldo());

		conta.saca(400);
	}
}
