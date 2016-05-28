package br.com.alura.ChaindOfResponsability;

public class DescontoCincoItens implements Desconto{

	private Orcamento orcamento;

	@Override
	public double calcula(Orcamento orcamento) {
		this.orcamento = orcamento;
		
		if(orcamento.getItens().size() > 5){
			return orcamento.getValor() * 0.10;
		}
		
		else {
			proximoDesconto(new MaiorQueQuinhentos());
		}
		return 0;
	}

	@Override
	public void proximoDesconto(Desconto desconto) {
		desconto.calcula(orcamento);
		
	}


}
