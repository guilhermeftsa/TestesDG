package testes.disciplinasgrupos.page;

import testes.disciplinasgrupos.core.BasePage;

public class DisciplinasEGruposPage extends BasePage {
	
	public void acessarDetalheTurma (String turma){
		clicarPorTexto("Turma "+turma);
	}	
	
	public boolean obterMensagemSemDisciplina(){
		return existeElementoPorTexto("Nenhuma disciplina");
	}
	
	public boolean existeCampoNome(){
		return existeElementoPorId("br.unifor.mobile:id/nome");
	}
	
	public boolean existeCampoCreditos(){
		return existeElementoPorId("br.unifor.mobile:id/creditos");
	}
	
	public boolean existeCampoTurma(){
		return existeElementoPorId("br.unifor.mobile:id/turma");
	}
	
	public boolean existeCampoSala(){
		return existeElementoPorId("br.unifor.mobile:id/sala");
	}
	
	public boolean existeCampoHorario(){
		return existeElementoPorId("br.unifor.mobile:id/horario");
	}
	
	public boolean existeCampoFrequencia(){
		return existeElementoPorId("br.unifor.mobile:id/frequencia");
	}
	
	
	
}
