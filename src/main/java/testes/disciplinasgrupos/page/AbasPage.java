package testes.disciplinasgrupos.page;

import testes.disciplinasgrupos.core.BasePage;

public class AbasPage extends BasePage {
	public void acessarAbaDisciplinas(){
		clicarPorTexto("DISCIPLINA");
	}
	
	public void acessarAbaFrequencia(){
		clicarPorTexto("FREQUÊNCIA");
	}
	
	public void acessarAbaAulas(){
		clicarPorTexto("AULAS");
	}
	

}
