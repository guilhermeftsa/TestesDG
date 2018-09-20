package testes.disciplinasgrupos.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import testes.disciplinasgrupos.core.BaseTest;
import testes.disciplinasgrupos.page.AbaAulasPage;
import testes.disciplinasgrupos.page.AbaDisciplinaPage;
import testes.disciplinasgrupos.page.AbaFrequenciaPage;
import testes.disciplinasgrupos.page.AbasPage;
import testes.disciplinasgrupos.page.DisciplinasEGruposPage;
import testes.disciplinasgrupos.page.LoginPage;
import testes.disciplinasgrupos.page.SidebarPage;

public class AbasDetalhesBemSucedidoTest extends BaseTest {

	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasEGruposPage disciplinasPage = new DisciplinasEGruposPage();
	private AbaDisciplinaPage disciplinaAba = new AbaDisciplinaPage();
	private AbasPage abas = new AbasPage();
	private AbaAulasPage aulasAba = new AbaAulasPage();
	private AbaFrequenciaPage frequenciaAba = new AbaFrequenciaPage();

	@Before
	public void setup() {
		esperar(2000);
		login.setLogin("1610358");
		login.setSenha("11111111");
		login.entrar();
		esperar(3000);
		sidebar.abrirMenu();
		sidebar.acessarDisciplinas();
		esperar(1000);
		disciplinasPage.acessarDetalheTurma("16");
	}

	// Automatiza o CT 998 - Tentar acessar a aba Disciplinas, 
	// Nos detalhes da disciplina selecionada
	@Test
	public void deveVerificarAbaDisciplinas_CT998() {
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
	}

	// Automatiza o CT 999 - Tentar acessar a aba Frequencia, 
	// Nos detalhes da disciplina selecionada
	@Test
	public void deveVerificarAbaFrequencia_CT999() {
		abas.acessarAbaFrequencia();
		Assert.assertTrue(frequenciaAba.existeCalendario());
	}

	// Automatiza o CT 1000 - Tentar acessar a aba Aulas, 
	// Nos detalhes da disciplina selecionada
	

}
