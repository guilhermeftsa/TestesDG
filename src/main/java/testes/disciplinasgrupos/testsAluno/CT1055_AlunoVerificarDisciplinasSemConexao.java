package testes.disciplinasgrupos.testsAluno;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import testes.disciplinasgrupos.core.BaseTest;
import testes.disciplinasgrupos.page.DisciplinasPage;
import testes.disciplinasgrupos.page.LoginPage;
import testes.disciplinasgrupos.page.SidebarPage;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT1055_AlunoVerificarDisciplinasSemConexao extends BaseTest {
	
	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinasPage = new DisciplinasPage();

	// Automatiza o CT 991 - Exibe a tela de disciplinas e
	// os dados referentes a cada disciplina
	@Test
	public void deveVerificarDisciplinasAlunoSemConexao_CT1055(@Param(name = "matricula") String matricula,
															   @Param(name = "senha") String senha) {		
		login.fazerLogin(matricula, senha);
		esperar(1000);		
		sidebar.acessarDisciplinasEGrupos();
		sidebar.abrirMenu();
		esperar(4000);
		sidebar.acessarPerfil();
		sidebar.acessarDisciplinasAlterandoWifi();
		
		Assert.assertTrue(disciplinasPage.obterMensagemSemInternet());
		Assert.assertTrue(disciplinasPage.existeCampoNomeDisciplina());
		Assert.assertTrue(disciplinasPage.existeCampoSala());
		Assert.assertTrue(disciplinasPage.existeCampoHorario());
		Assert.assertTrue(disciplinasPage.existeCampoFrequencia());
		Assert.assertTrue(disciplinasPage.isDisciplinasOrdenadas());
	}
	
	@After
	public void finaliza(){
		sidebar.alterarWifi();
	}
}
