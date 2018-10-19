package testes.disciplinasgrupos.page;

import static testes.disciplinasgrupos.core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import testes.disciplinasgrupos.core.BasePage;

public class GruposPage extends BasePage {
	
	public void acessarAbaDisciplinas(){
		clicarPorTexto("DISCIPLINAS");
	}
	
	public void acessarDetalheGrupo(String grupo) {
		clicarPorTexto(grupo);
	}
	
	public void realizarBuscaGrupos(String textoParaBuscar){
		clicar(MobileBy.AccessibilityId("Buscar"));
		escreverBy(By.id("br.unifor.mobile:id/text_query"), textoParaBuscar);
	}
	
	public boolean obterMensagemSemGrupos(){
		return existeElementoPorTexto("Usuário não associado a nenhum grupo");
	}
	
	public boolean checarBuscaVazia(){
		return existeElementoPorTexto("Não foram encontrados resultados na busca");
	}
	
	public boolean existeNomeGrupo(){
		return existeElementoPorId("br.unifor.mobile:id/titulo");
	}
	
	public boolean existeImagemGrupo(){
		return existeElementoPorId("br.unifor.mobile:id/foto");
	}
	
	public boolean existeNomeResponsavel(){
		return existeElementoPorId("br.unifor.mobile:id/responsavel");
	}
	
	public boolean isGruposOrdenados() {
		boolean ordenado = false;
		int contador = 0;
		
		//Salva a lista de Disciplinas exibidas formatadas sem o código		
		List<MobileElement> grupos = getDriver().findElements(By.id("br.unifor.mobile:id/titulo"));
		String gruposOrdenados[] = new String[grupos.size()];
		for (MobileElement grupo : grupos) {
			gruposOrdenados[contador] = grupo.getText();
			contador++;
		}

		int resultado = 0;
		//Ordena as disciplinas e confere se estão mesmo ordenadas alfabeticamente
		Arrays.sort(gruposOrdenados);
		System.out.println(Arrays.toString(gruposOrdenados));
		for (int j = 0; j <= gruposOrdenados.length-2; j++) {
			resultado = (gruposOrdenados[j].compareTo(gruposOrdenados[j+1]));
			if(resultado < 0){	
				ordenado = true;
			}else{
				ordenado = false;
				break;
			}
		}
		return ordenado;
	}
	
	public void acessarDetalheGrupoUnico() {
		clicar(By.id("br.unifor.mobile:id/titulo"));
	}
	
	public MobileElement obterUmGrupo(){		
		MobileElement disciplina;
		disciplina = getDriver().findElement(By.id("br.unifor.mobile:id/titulo"));
		return disciplina;
	}
}
