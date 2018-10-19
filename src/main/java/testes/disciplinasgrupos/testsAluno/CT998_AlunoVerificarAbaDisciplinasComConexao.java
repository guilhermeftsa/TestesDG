package testes.disciplinasgrupos.testsAluno;

import java.util.List;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.appium.java_client.MobileElement;
import testes.disciplinasgrupos.core.BaseTest;
import testes.disciplinasgrupos.page.AbaDisciplinaPage;
import testes.disciplinasgrupos.page.DisciplinasPage;
import testes.disciplinasgrupos.page.LoginPage;
import testes.disciplinasgrupos.page.SidebarPage;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT998_AlunoVerificarAbaDisciplinasComConexao extends BaseTest {
	private List<MobileElement> disciplinas;
	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinasPage = new DisciplinasPage();
	private AbaDisciplinaPage disciplinaAba = new AbaDisciplinaPage();

	// Automatiza o CT 998 - Tentar acessar a aba Disciplinas,
	// Nos detalhes da disciplina selecionada
	@Test
	public void deveVerificarAlunoAbaDisciplinasComConexao_CT998(@Param(name = "matricula") String matricula,
																 @Param(name = "senha") String senha) {
		esperar(2000);
		login.fazerLogin(matricula, senha);
		esperar(2000);
		sidebar.acessarDisciplinasEGrupos();
		esperar(1000);
		disciplinas = disciplinasPage.obterDisciplinasTeste();
		for (MobileElement disciplina : disciplinas) {
				esperar(4000);
				disciplinasPage.acessarDetalheTurma(disciplina);
				esperar(2000);
				Assert.assertTrue(disciplinaAba.existeCampoProfessor());
				Assert.assertTrue(disciplinaAba.existeCampoInfoSala());
				Assert.assertTrue(disciplinaAba.existeCampoInfoCodigo());
				Assert.assertTrue(disciplinaAba.existeCampoInfoCreditos());
				Assert.assertTrue(disciplinaAba.existeCampoInfoHorario());
				Assert.assertTrue(disciplinaAba.existeCampoNota1());
				Assert.assertTrue(disciplinaAba.existeCampoNota2());
				Assert.assertTrue(disciplinaAba.existeCampoNota3());
				disciplinaAba.ScrollDown();
				Assert.assertTrue(disciplinaAba.existeCampoFrequencia());
				Assert.assertTrue(disciplinaAba.existeCampoFaltas());
				disciplinaAba.voltarTela();
				esperar(2000);
				disciplinasPage.Scroll(0.9, 0.8);
		}
	}
}
