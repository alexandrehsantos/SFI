package br.com.alura.ChaindOfResponsability2;


public class SemResposta implements Resposta{

	@Override
	public void responde(Requisicao req, Conta conta) {
		System.out.println("Sem resposta");// TODO Auto-generated method stub
		
	}

	@Override
	public void setProxima(Resposta resposta) {
		// TODO Auto-generated method stub
		
	}	

}
