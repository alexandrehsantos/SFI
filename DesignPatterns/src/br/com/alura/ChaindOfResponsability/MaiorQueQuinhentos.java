package br.com.alura.ChaindOfResponsability;

public class MaiorQueQuinhentos implements Desconto {
	
	private Orcamento orcamento;
	
	@Override
	public double calcula(Orcamento orcamento) {
		
		this.orcamento = orcamento;
		
		if(orcamento.getValor() > 500.00){
			return orcamento.getValor() * 0.07;
		} else {
			proximoDesconto(new DescontoVazio());
		}
		return 0;
	}

	@Override
	public void proximoDesconto(Desconto desconto) {
		desconto.calcula(orcamento);
	}

}
