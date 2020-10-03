package com.github.marcosws.front.campotreinamento;

import com.github.marcosws.core.BasePage;
import com.github.marcosws.core.DriverFactory;

public class GeralFront extends BasePage {
	
	public GeralFront() {
		this.setDriver(DriverFactory.getDriver());
		this.setHighLight(true);
	}
	
	public String validaTitulo() {
		if(this.waitElement(Attribute.xpath, "/html/body/div[2]/form/h2", 20)) {
			return this.getTextElement(Attribute.xpath, "/html/body/div[2]/form/h2");
		}
		else {
			return "titulo não foi encontrado!";
		}
	}
	
	public void selecionaEstado(String estado) {
		this.selectElement(Attribute.id, "estado", estado);
	}
	public void selecionaNivel(String nivel) {
		this.selectElement(Attribute.name, "nivel", nivel);
	}
	public void selecionaPercentual1(String percentual1) { 
		this.selectElement(Attribute.tagName, "select",  percentual1, 3);
	}
	public void selecionaPercentual2(String percentual2) {
		this.selectElement(Attribute.tagName, "select",  percentual2, 4);
	}
	public void clicaAlert() { 
		this.clickElement(Attribute.className, "btnmsg", 0);
	}
	public void clicaConfirm() { 
		this.clickElement(Attribute.className, "btnmsg", 1);
	}
	public void clicaPrompt() {
		this.clickElement(Attribute.className, "btnmsg", 2);
	}
	public String validaAlert() {
		return this.dialogBox(true);
	}
	public String validaConfirm(boolean confirmar) {
		return this.dialogBox(confirmar);
	}
	public String validaPrompt(boolean confirmar, String texto) {
		return this.dialogBox(confirmar, texto);
	}
	
	public void clicaContinuar() {
		this.clickElement(Attribute.xpath, "/html/body/div[2]/form/input[1]");
	}

}
