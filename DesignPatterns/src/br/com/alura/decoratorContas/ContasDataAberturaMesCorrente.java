package br.com.alura.decoratorContas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContasDataAberturaMesCorrente extends Filtro {

	public ContasDataAberturaMesCorrente() {
		super();
	}

	public ContasDataAberturaMesCorrente(Filtro outraConta) {
		super(outraConta);
	}

	@Override
	protected List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtro = new ArrayList<>();

		for (Conta conta : contas) {
			
			if (conta.getDataAbertura().get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH)
					&& conta.getDataAbertura().get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
				
				
				filtro.add(conta);
			}
		}

		filtro.addAll(filtraOutraConta(contas));

		return filtro;
	}

}
