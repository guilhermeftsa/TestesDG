package testes.disciplinasgrupos.page;

import org.openqa.selenium.By;

import testes.disciplinasgrupos.core.BasePage;

public class LoginPage extends BasePage {
	public void setMatricula(String matricula){
		escreverBy(By.xpath("//*[@text = 'Matrícula']//android.widget.EditText"), matricula);
	}
	
	public void setSenha(String senha){
		escreverBy(By.xpath("//*[@text = 'Senha']//android.widget.EditText"), senha);
	}
	
	public void clicarEntrar(){
		clicarPorTexto("ACESSAR");
	}
	
	public void fazerLogin(String matricula, String senha){
		setMatricula(matricula);
		setSenha(senha);
		clicarEntrar();
	}
}
//android.widget.EditText