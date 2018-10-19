package testes.disciplinasgrupos.testsAluno;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import testes.disciplinasgrupos.core.BaseTest;
import testes.disciplinasgrupos.page.DisciplinasPage;
import testes.disciplinasgrupos.page.LoginPage;
import testes.disciplinasgrupos.page.SidebarPage;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT1009_VerificarDisciplinasEGruposComConexao extends BaseTest {

	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinasPage = new DisciplinasPage();
	
	@Test
	public void deveVerificarDisciplinasEGruposComConexao_CT1009(@Param(name = "matricula") String matricula,
			   													 @Param(name = "senha") String senha) {
		login.fazerLogin("1610358", "11111111");
		esperar(1000);
		sidebar.acessarDisciplinasEGrupos();
		Assert.assertTrue(disciplinasPage.existeDisciplina());
	}
}
