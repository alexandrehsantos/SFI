package br.com.alura.decoratorContas;

import java.util.ArrayList;
import java.util.List;

public class ContasSaldoMenorQueCem extends Filtro {

	
	public ContasSaldoMenorQueCem() {
		super();
	}
	
	public ContasSaldoMenorQueCem(Filtro outraConta){
		super(outraConta);
	}
	
	@Override
	public List<Conta> filtra(List<Conta> contas) {

		List<Conta> contasFiltradas = new ArrayList<>();

		for (Conta conta : contas) {
			if (conta.getSaldo() < 100) {
				contasFiltradas.add(conta);
			}
		}	
	
		contasFiltradas.addAll(filtraOutraConta(contas));
		return contasFiltradas;
		
	}

}
