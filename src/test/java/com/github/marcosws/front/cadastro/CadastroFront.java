package com.github.marcosws.front.cadastro;

import com.github.marcosws.core.BasePage;
import com.github.marcosws.core.DriverFactory;

public class CadastroFront extends BasePage {
	
	public CadastroFront() {
		this.setDriver(DriverFactory.getDriver());
	}

}
