package com.github.marcosws.context.cadastrounico;

import com.github.marcosws.context.ContextApp;
import com.github.marcosws.core.DriverFactory;
import com.github.marcosws.core.DriverFactory.Browser;


import com.github.marcosws.core.LogTest;

public class CadastroUnico {
	
	public void iniciarCadastroUnico() {

		LogTest logTest = new LogTest();
		logTest.LogInfo("Iniciando Cadastro");
		DriverFactory.setNavigator(Browser.FIREFOX);
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().get(ContextApp.ADDRESS_CADASTRO_UNICO);

	}
	
	public void finalizarCadastroUnico() {
		
		LogTest logTest = new LogTest();
		logTest.LogInfo("Finalizando Cadastro");
		DriverFactory.killDriver();
	}

}
