package testes.disciplinasgrupos.page;

import io.appium.java_client.MobileBy;
import testes.disciplinasgrupos.core.BasePage;

public class SidebarPage extends BasePage {
	public void abrirMenu(){
		clicar(MobileBy.AccessibilityId("Abrir menu"));
	}
	
	public void acessarDisciplinas(){
		clicarPorTexto("Minhas Disciplinas");
	}
}
