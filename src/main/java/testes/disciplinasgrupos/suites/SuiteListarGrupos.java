package testes.disciplinasgrupos.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.disciplinasgrupos.testsAluno.CT993_RealizarBuscaComResultado_Disciplinas;
import testes.disciplinasgrupos.testsAluno.CT994_RealizarBuscaSemResultado;
import testes.disciplinasgrupos.testsGrupos.CT1001_VerificarGrupos;
import testes.disciplinasgrupos.testsGrupos.CT1002_VerificarUsuarioSemGrupos;

@RunWith(Suite.class)
@SuiteClasses({
	CT1002_VerificarUsuarioSemGrupos.class,
	CT1001_VerificarGrupos.class,
	CT994_RealizarBuscaSemResultado.class,
	CT993_RealizarBuscaComResultado_Disciplinas.class,
}) 


public class SuiteListarGrupos {

}
