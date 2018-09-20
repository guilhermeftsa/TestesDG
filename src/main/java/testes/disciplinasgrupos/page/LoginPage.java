package testes.disciplinasgrupos.page;

import org.openqa.selenium.By;

import testes.disciplinasgrupos.core.BasePage;

public class LoginPage extends BasePage {
	public void setLogin(String login){
		escreverBy(By.xpath("//*[@text = 'Matrícula']//android.widget.EditText"), login);
	}
	
	public void setSenha(String senha){
		escreverBy(By.xpath("//*[@text = 'Senha']//android.widget.EditText"), senha);
	}
	
	public void entrar(){
		clicarPorTexto("ACESSAR");
	}
}
//android.widget.EditText