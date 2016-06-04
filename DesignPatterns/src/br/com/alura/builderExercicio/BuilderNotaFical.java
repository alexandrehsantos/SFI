package br.com.alura.builderExercicio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BuilderNotaFical {
	private String razaoSocial;
	private String cnpj;
	private double valorBruto;
	private double impostos;
	private Calendar dataEmissao;
	private String observacoes;
	private List<ItemDaNota> itens = new ArrayList<>();

	public BuilderNotaFical(){
		dataEmissao = Calendar.getInstance();
	}
	public BuilderNotaFical emNomeDe(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}
	public BuilderNotaFical noCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}
	public BuilderNotaFical itemDaNota(ItemDaNota item) {
		itens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.05;
		return this;
	}
	public BuilderNotaFical naData(Calendar data){
		dataEmissao = data;
		return this;
	}
	public BuilderNotaFical comObservacoes(String observacoes){
		this.observacoes = observacoes;
		return this;
	}
	public NotaFiscal buildNotaFical(){
		NotaFiscal nf = new NotaFiscal(razaoSocial, cnpj, valorBruto, impostos, dataEmissao, observacoes, itens);
		return nf;
	}
}
