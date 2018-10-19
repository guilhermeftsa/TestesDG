package testes.disciplinasgrupos.page;

import testes.disciplinasgrupos.core.BasePage;

public class GruposDetalhesPage extends BasePage {
	
	public boolean existeCampoNomeGrupo(){
		return existeElementoPorId("br.unifor.mobile:id/info_name_user_or_class");
	}
	
//	public boolean existeCampoNomeResponsavel(){
//	
//	}
	
	public void acessarAbaAulas(){
		clicarPorTexto("AULAS");
	}
}
