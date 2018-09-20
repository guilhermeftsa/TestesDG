package testes.disciplinasgrupos.page;

import testes.disciplinasgrupos.core.BasePage;

public class AbaAulasPage extends BasePage {

	public boolean existeMensagemErro(){
		return existeElementoPorTexto("Sem conexão com a internet");
	}
	
	public boolean existeBotaoTenteNovamente(){
		return existeElementoPorTexto("TENTAR NOVAMENTE");
	}
	
	public boolean isAbaSemAulas(){
		SwipeLeft();
		return existeElementoPorTexto("Não existe aula publicada");
	}
}
