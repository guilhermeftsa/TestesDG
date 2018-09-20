package testes.disciplinasgrupos.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import testes.disciplinasgrupos.core.BaseTest;
import testes.disciplinasgrupos.page.DisciplinasEGruposPage;
import testes.disciplinasgrupos.page.LoginPage;
import testes.disciplinasgrupos.page.SidebarPage;

public class DisciplinasEGruposTest extends BaseTest {
	
	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasEGruposPage disciplinasPage = new DisciplinasEGruposPage();
	
	@Before
	public void setup(){
		esperar(2000);
		login.setLogin("1610358");
		login.setSenha("11111111");
		login.entrar();	
	}
	
	//Automatiza o CT 990 - Tentar acessar a aba de disciplinas sem internet 
	//e sem dados salvos no banco local
	@Test
	public void deveVerificarSemConexao_CT990(){		
		esperar(3000);
		sidebar.abrirMenu();
		esperar(1000);
		sidebar.alterarWifi();
		esperar(1000);
		sidebar.acessarDisciplinas();
		Assert.assertTrue(disciplinasPage.obterMensagemSemInternet());
		Assert.assertTrue(disciplinasPage.obterMensagemSemDisciplina());
		sidebar.alterarWifi();
	}	
	
	//Automatiza o CT 991 - Exibe a tela de disciplinas e os dados referentes a cada disciplina
	@Test
	public void deveVerificarDisciplinas_CT991(){
		esperar(2000);
		sidebar.abrirMenu();
		esperar(500);
		sidebar.acessarDisciplinas();
		Assert.assertTrue(disciplinasPage.existeCampoNome());
		Assert.assertTrue(disciplinasPage.existeCampoTurma());
		Assert.assertTrue(disciplinasPage.existeCampoSala());
		Assert.assertTrue(disciplinasPage.existeCampoCreditos());
		Assert.assertTrue(disciplinasPage.existeCampoFrequencia());
		Assert.assertTrue(disciplinasPage.existeCampoHorario());		
	}	
}
