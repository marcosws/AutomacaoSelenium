package com.github.marcosws.context.cadastrounico;

import com.github.marcosws.context.ContextApp;
import com.github.marcosws.core.DriverFactory;
import com.github.marcosws.core.DriverFactory.Browser;

public class CadastroUnico {
	
	public void iniciarCadastroUnico() {

		DriverFactory.setNavigator(Browser.CHROME);
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().get(ContextApp.ADDRESS_CADASTRO_UNICO);

	}
	
	public void finalizarCadastroUnico() {
		
		DriverFactory.killDriver();
	}

}
