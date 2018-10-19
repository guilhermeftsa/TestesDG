package testes.disciplinasgrupos.testsGrupos;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import testes.disciplinasgrupos.core.BaseTest;
import testes.disciplinasgrupos.page.DisciplinasPage;
import testes.disciplinasgrupos.page.GruposDetalhesPage;
import testes.disciplinasgrupos.page.GruposPage;
import testes.disciplinasgrupos.page.LoginPage;
import testes.disciplinasgrupos.page.SidebarPage;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT1005_VerificarAbaGruposComConexao extends BaseTest {

	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinasPage = new DisciplinasPage();
	private GruposPage grupos = new GruposPage();
	private GruposDetalhesPage abaGrupos = new GruposDetalhesPage();
	
	
	
	@Test
	public void deveVerificarAbaGruposComConexao_CT1005(@Param(name = "matricula") String matricula,
														@Param(name = "senha") String senha){
		login.fazerLogin(matricula, senha);
		esperar(1000);		
		sidebar.acessarDisciplinasEGrupos();
		disciplinasPage.acessarGrupos();
		grupos.acessarDetalheGrupoUnico();
		
		Assert.assertTrue(abaGrupos.existeCampoNomeGrupo());
//		Assert.assertTrue(abaGrupos.existeCampoNomeResponsavel());
	}
}
