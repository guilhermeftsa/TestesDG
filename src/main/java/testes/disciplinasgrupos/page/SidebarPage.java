package testes.disciplinasgrupos.page;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import testes.disciplinasgrupos.core.BasePage;

public class SidebarPage extends BasePage {
		
	public void abrirMenu(){
		clicar(MobileBy.AccessibilityId("Abrir menu"));
	}
	
	public void acessarDisciplinasAlterandoWifi(){
		abrirMenu();
		alterarWifi();
		clicarPorTexto("Disciplinas e Grupos");
	}
	
	public void acessarDisciplinasEGrupos(){
		abrirMenu();		
		clicarPorTexto("Disciplinas e Grupos");
	}
	
	public void acessarPerfil(){
		clicar(By.id("br.unifor.mobile:id/profile_container"));
	}
}
