package testes.disciplinasgrupos.page;

import testes.disciplinasgrupos.core.BasePage;

public class AbaFrequenciaPage extends BasePage {
	
	private boolean retorno;
	
	public boolean existeCalendario(){
		return existeElementoPorId("br.unifor.mobile:id/recycler_view");
	}
	
	public boolean obterMensagemSemFrequencia(){
		return existeElementoPorTexto("Nenhuma frequência");
	}
	
	public boolean existemFrequenciasRealizadas(){
		retorno = true;
		if(existeElementoPorTexto("FREQUÊNCIAS REALIZADAS")){
			retorno = existeElementoPorId("br.unifor.mobile:id/realizadas_recycler_view");
		}
		return retorno;
	}
	
	public boolean existemFrequenciasAtrasadas(){
		retorno = true;
		if(existeElementoPorTexto("FREQUÊNCIAS ATRASADAS")){
			retorno = existeElementoPorId("br.unifor.mobile:id/atrasadas_recycler_view");
		}
		return retorno;
	}
	
	//OBTER ID CORRETO PARA FREQUENCIAS ATUAIS
	public boolean existemFrequenciasAtuais(){
		retorno = true;
		if(existeElementoPorTexto("FREQUÊNCIAS ATUAIS")){
			retorno = existeElementoPorId("br.unifor.mobile:id/atuais_recycler_view");
		}
		return retorno;
	}
}
