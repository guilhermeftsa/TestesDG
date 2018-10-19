package testes.disciplinasgrupos.testsLecionador;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import testes.disciplinasgrupos.core.BaseTest;
import testes.disciplinasgrupos.page.AbaDisciplinaPage;
import testes.disciplinasgrupos.page.DisciplinasPage;
import testes.disciplinasgrupos.page.LoginPage;
import testes.disciplinasgrupos.page.SidebarPage;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT1010_LecionadorVerificarAbaDisciplinaSemConexao extends BaseTest {
	
	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinasPage = new DisciplinasPage();
	private AbaDisciplinaPage disciplinaAba = new AbaDisciplinaPage();

	@Test
	public void deveVerificarLecionadorAbaDisciplinasSemConexao_CT1010(@Param(name = "matricula") String matricula, 
				 													   @Param(name = "senha") String senha) {
		login.fazerLogin(matricula, senha);
		esperar(2000);		
		sidebar.acessarDisciplinasEGrupos();
		esperar(1000);
		sidebar.alterarWifi();
		disciplinasPage.acessarDetalheTurmaUnica();
		
		Assert.assertTrue(disciplinaAba.obterMensagemSemInternet());
		Assert.assertTrue(disciplinaAba.existeCampoInfoSala());
		Assert.assertTrue(disciplinaAba.existeCampoTurma());
		Assert.assertTrue(disciplinaAba.existeCampoInfoCreditos());
		Assert.assertTrue(disciplinaAba.existeCampoInfoHorario());			
		Assert.assertTrue(disciplinaAba.existeCampoInfoSala());
		Assert.assertTrue(disciplinaAba.existeCampoNomeDisciplina());		
	}
	
	@After
	public void finalizar(){
		sidebar.alterarWifi();
	}
}
