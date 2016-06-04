package br.com.alura.builder;

import java.util.Calendar;
import java.util.List;

public class NotaFiscal {

	private String razaoSocial;
	private String cnpj;
	private Calendar dataDeEmissao;
	private double valorBruto;
	private double impostos;
	public List<ItemDaNota> itens;
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public Calendar getDataDeEmissao() {
		return dataDeEmissao;
	}
	public double getValorBruto() {
		return valorBruto;
	}
	public double getImposotos() {
		return impostos;
	}
	public List<ItemDaNota> getItens() {
		return itens;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public NotaFiscal(String razaoSocial, String cnpj, Calendar dataDeEmissao, double valorBruto, double imposotos,
			List<ItemDaNota> itens, String observacoes) {
		super();
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.dataDeEmissao = dataDeEmissao;
		this.valorBruto = valorBruto;
		this.impostos = imposotos;
		this.itens = itens;
		this.observacoes = observacoes;
	}
	private String observacoes;
	
	
	

}
