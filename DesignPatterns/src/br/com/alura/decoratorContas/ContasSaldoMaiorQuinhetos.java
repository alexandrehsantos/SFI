package br.com.alura.decoratorContas;

import java.util.ArrayList;
import java.util.List;

public class ContasSaldoMaiorQuinhetos extends Filtro {

	public ContasSaldoMaiorQuinhetos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContasSaldoMaiorQuinhetos(Filtro outraConta) {
		super(outraConta);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtro = new ArrayList<>();

		for (Conta conta : contas) {

			if (conta.getSaldo() > 500) {
				filtro.add(conta);
			} 
		}

		filtro.addAll(filtraOutraConta(contas));
		return filtro;
	}

}
