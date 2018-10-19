package testes.disciplinasgrupos.page;

import static testes.disciplinasgrupos.core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import testes.disciplinasgrupos.core.BasePage;

public class DisciplinasPage extends BasePage {

	public void acessarDetalheTurma(MobileElement disciplina) {
		disciplina.click();
//		disciplinas = getDriver().findElements(By.id("br.unifor.mobile:id/turma"));
//		return disciplinas;
	}
	
	public MobileElement obterUmaDisciplina(){		
		MobileElement disciplina;
		disciplina = getDriver().findElement(By.id("br.unifor.mobile:id/nomeDisciplina"));
		return disciplina;
	}
	
//	public List<MobileElement> obterDisciplinas(List<MobileElement> disciplinas){		
//		disciplinas = getDriver().findElements(By.id("br.unifor.mobile:id/containerTurma"));
//		System.out.println(disciplinas);
//		return disciplinas;
//	}
	
	public List<MobileElement> obterDisciplinasTeste(){		
		List<MobileElement> disc = getDriver().findElements(By.id("br.unifor.mobile:id/containerTurma"));
		return disc;
	}
	
	public void acessarDetalheTurmaUnica() {
		clicar(By.id("br.unifor.mobile:id/turma"));
	}
	
	public void acessarDetalheDisciplinaUnica() {
		clicar(By.id("br.unifor.mobile:id/containerTurma"));
	}
	
	public boolean existeDisciplina(){
		return existeElementoPorId("br.unifor.mobile:id/rlDisciplina");
	}

	public boolean obterMensagemSemDisciplina() {
		return existeElementoPorTexto("Não há disciplinas");
	}

	public boolean existeCampoNomeDisciplina() {
		return existeElementoPorId("br.unifor.mobile:id/nomeDisciplina");
	}

	public boolean existeCampoCreditos() {
		return existeElementoPorId("br.unifor.mobile:id/creditos");
	}

	public boolean existeCampoTurma() {
		return existeElementoPorId("br.unifor.mobile:id/turma");
	}

	public boolean existeCampoSala() {
		return existeElementoPorId("br.unifor.mobile:id/sala");
	}

	public boolean existeCampoHorario() {
		return existeElementoPorId("br.unifor.mobile:id/horario");
	}

	public boolean existeCampoFrequencia() {
		return existeElementoPorId("br.unifor.mobile:id/frequencia");
	}
	
	public boolean verificarSemDisciplina(){
		return existeElementoPorTexto("Não há disciplinas");
	}
	
	public boolean isDisciplinasOrdenadas() {
		boolean ordenado = false;
		int contador = 0;
		
		//Salva a lista de Disciplinas exibidas formatadas sem o código		
		List<MobileElement> disciplinas = getDriver().findElements(By.id("br.unifor.mobile:id/nomeDisciplina"));
		String disciplinasOrdenadas[] = new String[disciplinas.size()];
		for (MobileElement disciplina : disciplinas) {
			disciplinasOrdenadas [contador]= disciplina.getText();
			contador++;
		}

		int resultado = 0;
		//Ordena as disciplinas e confere se estão mesmo ordenadas alfabeticamente
		Arrays.sort(disciplinasOrdenadas);
		System.out.println(Arrays.toString(disciplinasOrdenadas));
		for (int j = 0; j <= disciplinasOrdenadas.length-2; j++) {
			resultado = (disciplinasOrdenadas[j].compareTo(disciplinasOrdenadas[j+1]));
			if(resultado < 0){	
				ordenado = true;
			}else{
				ordenado = false;
				break;
			}
		}
		return ordenado;
	}
	
	public void realizarBuscaDisciplinas(String textoParaBuscar){
		clicar(MobileBy.AccessibilityId("Buscar"));
		escreverBy(By.id("br.unifor.mobile:id/text_query"), textoParaBuscar);
	}
	
	public void acessarGrupos(){
		clicarPorTexto("GRUPOS");
	}
	
	public boolean checarBuscaVazia(){
		return existeElementoPorTexto("Não há disciplinas");
	}
	
	public boolean checarBuscaComResultado(String textoBuscado){
		return existeElementoPorTexto(textoBuscado);
	}
	
	public boolean existeCampoCodigoTurmaDisciplina() {
		MobileElement elemento = getDriver().findElement(By.id("br.unifor.mobile:id/turmaDisciplina"));
		
		Boolean retorno = false;
		
		String turmaCompleta = elemento.getText();
		String codigoNumeros = turmaCompleta.substring(1, 4);
		String codigoLetra = turmaCompleta.substring(0, 1);
		String hifen = turmaCompleta.substring(5, 6);
		String turma = turmaCompleta.substring(7);
		
		String regexLetras = "[A-Z]";
		String regexNumeros = "(.)*(\\d)(.)*";
		Pattern patternNumeros = Pattern.compile(regexNumeros);
		Pattern patternLetras = Pattern.compile(regexLetras);

		boolean turmaPossuiNumeros = patternNumeros.matcher(turma).matches();
		boolean codigoPossuiNumeros = patternNumeros.matcher(codigoNumeros).matches();
		boolean codigoPossuiLetra = patternLetras.matcher(codigoLetra).matches();
		
		if(turmaPossuiNumeros && codigoPossuiNumeros && codigoPossuiLetra){
			if(hifen.equals("-")){
				retorno = true;
			}
		}
		
		return retorno;
	}
}
