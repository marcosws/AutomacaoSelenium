package com.github.marcosws.context.campotreinamento;

import com.github.marcosws.context.ContextApp;
import com.github.marcosws.core.DriverFactory;
import com.github.marcosws.core.DriverFactory.Browser;

public class CampoTreinamento {
	
	public void iniciarCampoTreinamento() {

		DriverFactory.setNavigator(Browser.FIREFOX);
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().get(ContextApp.ADDRESS_CAMPO_TREINAMENTO);

	}
	
	public void finalizarCampoTreinamento() {
		
		DriverFactory.killDriver();
	}

}
