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
import testes.disciplinasgrupos.page.AbaFrequenciaPage;
import testes.disciplinasgrupos.page.AbasPage;
import testes.disciplinasgrupos.page.DisciplinasPage;
import testes.disciplinasgrupos.page.LoginPage;
import testes.disciplinasgrupos.page.SidebarPage;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT996_AlunoVerificarAbaFrequenciaSemConexao extends BaseTest {

	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinasPage = new DisciplinasPage();
	private AbasPage abas = new AbasPage();
	private AbaFrequenciaPage frequenciaAba = new AbaFrequenciaPage();

	// Automatiza o CT 996 - Tentar acessar a aba Frequencia, nos detalhes da disciplina selecionada
	// Sem conexão com a internet
	@Test
	public void deveVerificarAlunoAbaFrequenciaSemConexao_CT996(@Param(name = "matricula") String matricula, 
														   		@Param(name = "senha") String senha) {
		login.fazerLogin(matricula, senha);
		esperar(2000);		
		sidebar.acessarDisciplinasEGrupos();
		esperar(1000);
		sidebar.alterarWifi();
		disciplinasPage.acessarDetalheDisciplinaUnica();		
		Assert.assertTrue(frequenciaAba.obterMensagemSemInternet());
		abas.acessarAbaFrequencia();
		Assert.assertTrue(frequenciaAba.existeCalendario());
	}
	
	@After
	public void finaliza(){
		sidebar.alterarWifi();
	}

}
