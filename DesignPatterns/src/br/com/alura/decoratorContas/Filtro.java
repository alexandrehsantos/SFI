package br.com.alura.decoratorContas;

import java.util.ArrayList;
import java.util.List;

abstract class Filtro {

	protected Filtro outraConta;

	public Filtro() {
		this.outraConta = null;// TODO Auto-generated constructor stub
	}

	public Filtro(Filtro outraConta) {
		this.outraConta = outraConta;
	}

	protected abstract List<Conta> filtra(List<Conta> contas);

	protected List<Conta> filtraOutraConta(List<Conta> contas) {

		return (outraConta != null) ? outraConta.filtra(contas) : new ArrayList<Conta>();
	}

}
