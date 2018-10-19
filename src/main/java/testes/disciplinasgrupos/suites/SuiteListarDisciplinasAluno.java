package testes.disciplinasgrupos.suites;

import static testes.disciplinasgrupos.core.DriverFactory.getDriver;
import static testes.disciplinasgrupos.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.disciplinasgrupos.testsAluno.CT1000_AlunoVerificarAbaAulasComConexao;
import testes.disciplinasgrupos.testsAluno.CT1055_AlunoVerificarDisciplinasSemConexao;
import testes.disciplinasgrupos.testsAluno.CT1056_VerificarDisciplinasSemConexao;
import testes.disciplinasgrupos.testsAluno.CT991_AlunoVerificarDisciplinasComConexao;
import testes.disciplinasgrupos.testsAluno.CT992_VerificarSemDisciplina;
import testes.disciplinasgrupos.testsAluno.CT993_RealizarBuscaComResultado_Disciplinas;
import testes.disciplinasgrupos.testsAluno.CT994_RealizarBuscaSemResultado;
import testes.disciplinasgrupos.testsAluno.CT995_AlunoVerificarAbaDisciplinasSemConexao;
import testes.disciplinasgrupos.testsAluno.CT996_AlunoVerificarAbaFrequenciaSemConexao;
import testes.disciplinasgrupos.testsAluno.CT997_AlunoVerificarAbaAulasSemConexao;
import testes.disciplinasgrupos.testsAluno.CT998_AlunoVerificarAbaDisciplinasComConexao;
import testes.disciplinasgrupos.testsAluno.CT999_AlunoVerificarAbaFrequenciaComConexao;

@RunWith(Suite.class)
@SuiteClasses({
	CT1056_VerificarDisciplinasSemConexao.class,	
	CT992_VerificarSemDisciplina.class,
	CT991_AlunoVerificarDisciplinasComConexao.class,
	CT1055_AlunoVerificarDisciplinasSemConexao.class,
	CT994_RealizarBuscaSemResultado.class,	
	CT993_RealizarBuscaComResultado_Disciplinas.class,
	CT995_AlunoVerificarAbaDisciplinasSemConexao.class,
	CT996_AlunoVerificarAbaFrequenciaSemConexao.class,
	CT997_AlunoVerificarAbaAulasSemConexao.class,
	CT998_AlunoVerificarAbaDisciplinasComConexao.class,
	CT999_AlunoVerificarAbaFrequenciaComConexao.class,	
	CT1000_AlunoVerificarAbaAulasComConexao.class
})

public class SuiteListarDisciplinasAluno {

	@AfterClass
	public static void tearDown(){
		getDriver().quit();
		killDriver();
	}
}
