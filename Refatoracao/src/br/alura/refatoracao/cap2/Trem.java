package br.alura.refatoracao.cap2;

import java.util.List;

public class Trem {

	private List<Vagao> vagoes;
	private int capacidade;

	public boolean podeOcorrerReserva(int lugaresAReservar) {

		int lugaresJaReservados = lugaresJaReservados();

		return capacidade - lugaresJaReservados > lugaresAReservar;
	}

	private int lugaresJaReservados() {
		int reservados = 0;
		for (Vagao vagao : vagoes) {
			reservados += vagao.reservados();
		}
		return reservados;
	}

}