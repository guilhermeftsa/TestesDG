package testes.disciplinasgrupos.core;

import static testes.disciplinasgrupos.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BasePage {
		
	public void alterarWifi(){
		ScrollMenu();
		clicar(By.xpath("//android.widget.Switch[6]"));
		Scroll(0.95, 0.05);
		//getDriver().setConnection(Connection.AIRPLANE);
	}
	
	public void escreverBy(By by, String texto){
		getDriver().findElement(by).sendKeys(texto);		
	}
	
	public String obterTexto(By by){
		return getDriver().findElement(by).getText();
	}
	
	public void clicar(By by){
		getDriver().findElement(by).click();
	}
	
	public void clicarPorTexto(String texto){
		clicar(By.xpath("//*[@text = '"+texto+"']"));
	}
	
	public void selecionarCombo(By by, String valor){
		getDriver().findElement(by).click();;
		clicarPorTexto(valor);
	}
	
	public boolean isCheckMarcado(By by){
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}	
	
	public boolean existeElementoPorTexto(String texto){
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text = '"+texto+"']"));
		return elementos.size()>0;
	}
	
	public boolean existeElementoPorId(String id){
		List<MobileElement> elementos = getDriver().findElements(By.id(id));
		return elementos.size()>0;
	}
	
	public void Tap(int x, int y){
		new TouchAction(getDriver()).tap(x, y).perform();
	}
	
	public void Scroll(double inicio, double fim){
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width/2;
		int y_inicial = (int) (size.height * inicio); 
		int y_final = (int) (size.height * fim);
		
		new TouchAction(getDriver())
			.press(x, y_inicial)
			.waitAction(Duration.ofMillis(500))
			.moveTo(x, y_final)
			.release().perform();
	}
	
	public void ScrollDown(){
		Scroll(0.9, 0.1);
	}
	
	public void ScrollUp(){
		Scroll(0.1, 0.9);
	}
	
	public void Swipe(double inicio, double fim){
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height/2;
		int x_inicial = (int) (size.width * inicio); 
		int x_final = (int) (size.width * fim);
		
		new TouchAction(getDriver())
			.press( x_inicial, y)
			.waitAction(Duration.ofMillis(500))
			.moveTo(x_final, y)
			.release().perform();
	}
	
	public void SwipeElement(MobileElement element, double inicio, double fim){		
		int y = element.getLocation().y + (element.getSize().height /2);
		int x_inicial = (int) (element.getSize().width * inicio); 
		int x_final = (int) (element.getSize().width * fim);
		
		new TouchAction(getDriver())
			.press( x_inicial, y)
			.waitAction(Duration.ofMillis(500))
			.moveTo(x_final, y)
			.release().perform();
	}
	
	public void SwipeLeft(){
		Scroll(0.1, 0.9);
	}
	
	public void SwipeRight(){
		Scroll(0.9, 0.1);
	}
	
	public String obterTituloAlerta(){
		return obterTexto(By.id("android:id/alertTitle"));
	}
	
	public String obterMensagemAlerta(){
		return obterTexto(By.id("android:id/message"));
	}
	
	public void cliqueLongo(By by){
		new TouchAction(getDriver())
				.longPress
				(getDriver().findElement(by))
				.perform();
	}
	
	public void ScrollMenu(){
		Dimension size = getDriver().manage().window().getSize();
		
		double inicio = 0.03;
		double fim = 0.98;
		
		int x = size.width/2;
		int y_inicial = (int) (size.height * inicio); 
		int y_final = (int) (size.height * fim);
		
		new TouchAction(getDriver())
			.press(x, y_inicial)
			.waitAction(Duration.ofMillis(300))
			.moveTo(x, y_final)
			.release().perform();
	}
	
	public boolean obterMensagemSemInternet(){
		return existeElementoPorTexto("Sem conexão com a internet.");
	}
}
