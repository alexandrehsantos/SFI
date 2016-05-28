package br.com.alura.ChaindOfResponsability2;

public class TesteRequisicao {
	public static void main(String[] args) {

		Conta conta = new Conta("Titular1", 1000);
		Requisicao req = new Requisicao(Formato.XML);
		
		Resposta resp1 = new RequisicaoXml();
		Resposta resp2 = new RequisicaoCsv();
		Resposta resp3 = new RequisicaoPorcento();
		Resposta resp4 = new SemResposta();
		
		resp1.setProxima(resp2);
		resp2.setProxima(resp3);
		resp3.setProxima(resp4);
		
		resp1.responde(req, conta);
		
		
		
		
		
	}
}
