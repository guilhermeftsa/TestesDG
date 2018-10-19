package testes.disciplinasgrupos.testsAluno;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.appium.java_client.MobileElement;
import testes.disciplinasgrupos.core.BaseTest;
import testes.disciplinasgrupos.page.DisciplinasPage;
import testes.disciplinasgrupos.page.LoginPage;
import testes.disciplinasgrupos.page.SidebarPage;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT993_RealizarBuscaComResultado_Disciplinas extends BaseTest {
	String nomeBuscado;
	private MobileElement elemento;
	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinas = new DisciplinasPage();
	
	@Test
	public void deveRealizarBuscaComResultado_Disciplinas_CT993(@Param(name = "matricula") String matricula, 
			   													@Param(name = "senha") String senha){
		login.fazerLogin(matricula, senha);
		esperar(1000);		
		sidebar.acessarDisciplinasEGrupos();
		elemento = disciplinas.obterUmaDisciplina();
		nomeBuscado = elemento.getText();
		disciplinas.realizarBuscaDisciplinas(nomeBuscado.substring(0, 1));
		Assert.assertTrue(disciplinas.checarBuscaComResultado(nomeBuscado));
	}
}
