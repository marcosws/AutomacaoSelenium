package com.github.marcosws.front.cadastrounico;

import com.github.marcosws.core.DriverFactory;
import com.github.marcosws.core.BasePage;

public class ParametrosCadastroFront extends BasePage {
	
	public ParametrosCadastroFront() {
		this.setDriver(DriverFactory.getDriver());
		this.setHighLight(true);
	}
	
	public void clicaAbaParametros() {
		this.clickElement(Attribute.id, "aba-parametros");
	}
	
	public String validaTitulo() {
		return this.getTextElement(Attribute.xpath, "/html/body/doctype/div/div[2]/div[4]/h2");
	}
	
	public void selecionaApresentarCaixaDeDialogo() {
		this.clickElement(Attribute.id, "radio3");
	}
	public void selecionaApresentarLabelInformativa() {
		this.clickElement(Attribute.id, "radio4");
	}
	
	public void selecionaApresentarMensagemDeConfirmacaoDeCadastro(boolean checado) {
		if(checado != this.ckeckedElement(Attribute.id, "mensagem-cadastro")) {
			this.clickElement(Attribute.xpath, "/html/body/doctype/div/div[2]/div[4]/fieldset[2]/label[1]/span");
		}
	}
	
	public void selecionaApresentarMensagemDeConfirmacaoAntesDeLimparOsCampos(boolean checado) {
		if(checado != this.ckeckedElement(Attribute.id, "mensagem-limpar")) {
			this.clickElement(Attribute.xpath, "/html/body/doctype/div/div[2]/div[4]/fieldset[2]/label[2]/span");
		}
	}

}
