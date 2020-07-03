package com.github.marcosws.nav.cadastro;

import com.github.marcosws.context.ContextApp;
import com.github.marcosws.core.DriverFactory;
import com.github.marcosws.core.DriverFactory.Browser;

public class CadastroNav {
	
	public void iniciarCadastro() {

		DriverFactory.setNavigator(Browser.CHROME);
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().get(ContextApp.ADDRESS_PROTO_CAD);

	}
	
	public void finalizarCadastro() {
		DriverFactory.killDriver();
	}
	
	public void executaCadastro(String nomeClasse) {
		
	}
	
	public void executaParametros(String nomeClasse) {
		
	}
}
