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
import testes.disciplinasgrupos.page.AbaFrequenciaPage;
import testes.disciplinasgrupos.page.AbasPage;
import testes.disciplinasgrupos.page.DisciplinasPage;
import testes.disciplinasgrupos.page.LoginPage;
import testes.disciplinasgrupos.page.SidebarPage;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT999_AlunoVerificarAbaFrequenciaComConexao extends BaseTest {
	private List<MobileElement> disciplinas;
	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinasPage = new DisciplinasPage();
	private AbasPage abas = new AbasPage();
	private AbaFrequenciaPage frequenciaAba = new AbaFrequenciaPage();

	// Automatiza o CT 999 - Tentar acessar a aba Frequencia,
	// Nos detalhes da disciplina selecionada
	@Test
	public void deveVerificarAlunoAbaFrequenciaComConexao_CT999(@Param(name = "matricula") String matricula,
																@Param(name = "senha") String senha) {
		login.fazerLogin(matricula, senha);
		esperar(2000);
		sidebar.acessarDisciplinasEGrupos();
		esperar(1000);
		disciplinas = disciplinasPage.obterDisciplinasTeste();
		for (MobileElement disciplina : disciplinas) {
			esperar(4000);
			disciplinasPage.acessarDetalheTurma(disciplina);
			esperar(1000);
			abas.acessarAbaFrequencia();
			Assert.assertTrue(frequenciaAba.existeCalendario());
			esperar(1000);
			frequenciaAba.clicarVoltar();
			esperar(2000);
			disciplinasPage.Scroll(0.9, 0.8);
		}
	}
}
