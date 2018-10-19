package testes.disciplinasgrupos.page;

import org.openqa.selenium.By;

import testes.disciplinasgrupos.core.BasePage;

public class AbaAulasPage extends BasePage {

	public boolean existeMensagemErroAulas(){
		return existeElementoPorTexto("Sem conexão com a internet");
	}
	
	public boolean existeBotaoTenteNovamente(){
		return existeElementoPorTexto("TENTAR NOVAMENTE");
	}
	
	public boolean existeAulas(){
		return existeElementoBy(By.className("android.webkit.WebView"));
	}
	
	public boolean isAbaSemAulas(){
		SwipeLeft();
		return existeElementoPorTexto("Não existe aula publicada");
	}
}
