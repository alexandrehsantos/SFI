package br.alura.refatoracao.cap3;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestaMatricula {
	public static void main(String[] args) {
		
		Matricula matricula = new Matricula(false, new GregorianCalendar(2020, Calendar.APRIL,2));
		
		if(matricula.estaValida()){
			System.out.println("legal, vc eh um usuario com acesso ilimitado!!");
		}
		
		
	}
}
