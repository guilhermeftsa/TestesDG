package testes.disciplinasgrupos.page;

import testes.disciplinasgrupos.core.BasePage;

public class AbaDisciplinaPage extends BasePage {

	public boolean existeCampoProfessor(){
		return existeElementoPorId("br.unifor.mobile:id/info_name_user_or_class");
	}
	
	public boolean existeCampoInfoSala(){
		return existeElementoPorId("br.unifor.mobile:id/info_sala");
	}
	
	public boolean existeCampoInfoCodigo(){
		return existeElementoPorId("br.unifor.mobile:id/info_codigo");
	}
	
	public boolean existeCampoInfoCreditos(){
		return existeElementoPorId("br.unifor.mobile:id/info_codigo");
	}
	
	public boolean existeCampoInfoHorario(){
		return existeElementoPorId("br.unifor.mobile:id/info_horario");
	}
	
	public boolean existeCampoNota1(){
		return existeElementoPorId("br.unifor.mobile:id/av1");
	}
	
	public boolean existeCampoNota2(){
		return existeElementoPorId("br.unifor.mobile:id/av2");
	}
	
	public boolean existeCampoNota3(){
		return existeElementoPorId("br.unifor.mobile:id/av3");
	}
	
	public boolean existeCampoFrequencia(){
		return existeElementoPorId("br.unifor.mobile:id/presenca");
	}
	
	public boolean existeCampoFaltas(){
		return existeElementoPorId("br.unifor.mobile:id/faltas");
	}
	
}
