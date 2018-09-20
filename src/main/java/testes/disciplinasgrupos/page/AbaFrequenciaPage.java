package testes.disciplinasgrupos.page;

import testes.disciplinasgrupos.core.BasePage;

public class AbaFrequenciaPage extends BasePage {
	
	public boolean existeCalendario(){
		return existeElementoPorId("br.unifor.mobile:id/recycler_view");
	}
}
