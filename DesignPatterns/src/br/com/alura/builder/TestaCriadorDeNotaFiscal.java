package br.com.alura.builder;

public class TestaCriadorDeNotaFiscal {
	public static void main(String[] args) {
		
		NotaFiscalBuilder builder = new NotaFiscalBuilder();
		builder.paraEmpresa("Caelum Ensino e Inovacao")
		.comCnpj("5646546")
		.comItem(new ItemDaNota("item1", 200.00))
		.comItem(new ItemDaNota("item 2", 300.00))
		.comItem(new ItemDaNota("item 3", 400.00))
		.comObservacao("observacoes")
		.naDataAtual();
		
		NotaFiscal nf = builder.constroi();

		System.out.println(nf.getValorBruto());
	}
}
