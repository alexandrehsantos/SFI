package br.com.alura.builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalBuilder {

	private String razaoSocial;
	private String cnpj;
	private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();
	private double valorBruto;
	private double impostos;
	private String observacoes;
	private Calendar dataDeEmissao;
	
	public NotaFiscalBuilder paraEmpresa(String razaoSocial){
		this.razaoSocial = razaoSocial;
		return this;
	}
	
	public NotaFiscalBuilder comCnpj(String cnpj){
		this.cnpj = cnpj;
		return this;
	}
	
	public NotaFiscalBuilder comItem(ItemDaNota item){
		todosItens.add(item);
		valorBruto += item.getValor();
		impostos = item.getValor() * 0.05;
		return this;
	}
	
	public NotaFiscalBuilder comObservacao(String observacao){
		this.observacoes = observacao;
		return this;
	}
	
	public NotaFiscalBuilder naDataAtual(){
		dataDeEmissao = Calendar.getInstance();
		return this;
	}
	
	public NotaFiscal constroi(){
		return new NotaFiscal(razaoSocial, cnpj, dataDeEmissao, valorBruto, impostos, todosItens, observacoes);
	}
}

