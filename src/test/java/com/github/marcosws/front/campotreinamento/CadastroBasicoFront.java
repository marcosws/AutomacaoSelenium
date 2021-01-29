package com.github.marcosws.front.campotreinamento;

import com.github.marcosws.core.BasePage;
import com.github.marcosws.core.DriverFactory;

public class CadastroBasicoFront extends BasePage{

	public CadastroBasicoFront() {
		this.setDriver(DriverFactory.getDriver());
		this.setHighLight(true);
	}
	
	public String validaTitulo() {
		if(this.waitElement(Attribute.xpath, "/html/body/div[1]/form/h2", 20)) {
			return this.getTextElement(Attribute.xpath, "/html/body/div[1]/form/h2");
		}
		else {
			return "titulo não foi encontrado!";
		}
	}
	
	public void digitaNome(String nome) {
		this.editElement(Attribute.tagName, "input", nome, 0);
	}
	public void digitaEndereco(String endereco) {
		this.editElement(Attribute.tagName, "input", endereco, 1);
	}
	public void digitaNumero(String numero) {
		this.editElement(Attribute.tagName, "input", numero, 2);
	}
	public void digitaCep(String cep) {
		this.editElement(Attribute.tagName, "input", cep, 3);
	}
	
	public void selecionaEstudante(boolean checked) {
		this.selectElement(Attribute.name, "rb1", checked, 0);
	}
	public void selecionaProfissionalClt(boolean checked) {
		this.selectElement(Attribute.name, "rb1", checked, 1);
	}
	public void selecionaEmpresario(boolean checked) {
		this.selectElement(Attribute.name, "rb1", checked, 2);
	}
	
	public void selecionaPossuiCarro(boolean checked) {
		this.selectElement(Attribute.name, "carro", checked);
	}
	public void selecionaPossuiMoto(boolean checked) {
		this.selectElement(Attribute.name, "moto", checked);
	}
	public void selecionaPossuiUtilitario(boolean checked) {
		this.selectElement(Attribute.name, "utilitario", checked);
	}
	
	public void selecionaMontadora(String montadora) {
		this.selectElement(Attribute.name, "cars", montadora);
	}
	
	public void clicaContinuar() {
		this.clickElement(Attribute.xpath, "/html/body/div[1]/form/input[5]");
	}

}
