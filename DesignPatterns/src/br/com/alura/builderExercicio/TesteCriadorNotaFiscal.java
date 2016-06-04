package br.com.alura.builderExercicio;

import java.util.Calendar;

public class TesteCriadorNotaFiscal {
	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		
		
		BuildItemNota item1 = new BuildItemNota();
		BuildItemNota item2 = new BuildItemNota();

		item1.comDescricao("item1")
		.comValor(123456);
		item2.comDescricao("item2")
		.comValor(789456);
		
		BuilderNotaFical builder = new BuilderNotaFical();
		builder.emNomeDe("Empresa XXX")
		.noCnpj("123456789")
		.itemDaNota(item1.build())
		.itemDaNota(item2.build())
		.naData(calendar.set(2015, 06, 12))
		.comObservacoes("xxxxxxxx");
		NotaFiscal nf = builder.buildNotaFical();
		System.out.println(nf.getValorBruto());
		System.out.println(nf.getImpostos());
		System.out.println(nf.getDataEmissao().getTime());
		
	}	
}
