package testes.disciplinasgrupos.suites;

import static testes.disciplinasgrupos.core.DriverFactory.getDriver;
import static testes.disciplinasgrupos.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.disciplinasgrupos.testsAluno.CT1009_VerificarDisciplinasEGruposComConexao;

@RunWith(Suite.class)
@SuiteClasses({
	CT1009_VerificarDisciplinasEGruposComConexao.class
})

public class SuiteAcessarDisciplinasEGrupos{

	@AfterClass
	public static void tearDown(){
		getDriver().quit();
		killDriver();
	}
}
