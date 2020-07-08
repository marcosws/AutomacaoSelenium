package com.github.marcosws.front.cadastro;

import com.github.marcosws.core.BasePage;
import com.github.marcosws.core.DriverFactory;

public class CadastroFront extends BasePage {
	
	public CadastroFront() {
		this.setDriver(DriverFactory.getDriver());
	}
	
	public void digitaNome(String nome) {
		this.editElement(Attribute.id, "nome", nome);
	}
	
	public void digitaCpf(String cpf) {
		this.editElement(Attribute.id, "cpf", cpf);
	}

}
