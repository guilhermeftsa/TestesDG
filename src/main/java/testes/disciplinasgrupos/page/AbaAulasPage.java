package testes.disciplinasgrupos.page;

import testes.disciplinasgrupos.core.BasePage;

public class AbaAulasPage extends BasePage {

	public boolean existeMensagemErro(){
		return existeElementoPorTexto("Sem conex�o com a internet");
	}
	
	public boolean existeBotaoTenteNovamente(){
		return existeElementoPorTexto("TENTAR NOVAMENTE");
	}
	
	public boolean isAbaSemAulas(){
		SwipeLeft();
		return existeElementoPorTexto("N�o existe aula publicada");
	}
}
