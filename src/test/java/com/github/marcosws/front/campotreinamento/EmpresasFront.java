package com.github.marcosws.front.campotreinamento;

import com.github.marcosws.core.BasePage;
import com.github.marcosws.core.DriverFactory;

public class EmpresasFront extends BasePage {
	
	public EmpresasFront() {
		this.setDriver(DriverFactory.getDriver());
		this.setHighLight(true);
	}
	
	public String validaTitulo() {
		if(this.waitElement(Attribute.xpath, "/html/body/div[3]/form/h2", 20)) {
			return this.getTextElement(Attribute.xpath, "/html/body/div[3]/form/h2");
		}
		else {
			return "titulo não foi encontrado!";
		}
	}

}
