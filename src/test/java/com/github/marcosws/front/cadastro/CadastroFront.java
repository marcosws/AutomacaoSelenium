package com.github.marcosws.front.cadastro;

import com.github.marcosws.core.BasePage;
import com.github.marcosws.core.DriverFactory;

public class CadastroFront extends BasePage {
	
	public CadastroFront() {
		this.setDriver(DriverFactory.getDriver());
		this.setHighLight(true);
	}
	/**
	 * Ação: Seleciona Radio Button Pessoa Física
	 * @author Marcos
	 */
	public void selecionaPessoaFisica() {
		this.clickElement(Attribute.id, "radio1");
	}
	/**
	 * Ação: Seleciona Radio Button Pessoa Jurídica
	 * @author Marcos
	 */
	public void selecionaPessoaJuridica() {
		this.clickElement(Attribute.id, "radio2");
	}
	/**
	 * Ação: 
	 * @author Marcos
	 */
	public void digitaNome(String nome) {
		this.editElement(Attribute.id, "nome", nome);
	}
	/**
	 * Ação: 
	 * @author Marcos
	 */
	public void digitaCpf(String cpf) {
		this.editElement(Attribute.id, "cpf", cpf);
	}
	/**
	 * Ação: 
	 * @author Marcos
	 */
	public void digitaNomeFantasia(String nomeFantasia) {
		this.editElement(Attribute.id, "nomeFantasia", nomeFantasia);
	}
	/**
	 * Ação: 
	 * @author Marcos
	 */
	public void digitaRazaoSocial(String razaoSocial) {
		this.editElement(Attribute.id, "razaoSocial",  razaoSocial);
	}
	/**
	 * Ação: 
	 * @author Marcos
	 */
	public void digitaCnpj(String cnpj) {
		this.editElement(Attribute.id, "cnpj", cnpj);
	}
	/**
	 * Ação: 
	 * @author Marcos
	 */
	public void digitaTelefone(String telefone) {
		this.editElement(Attribute.id, "telefone", telefone);
	}
	/**
	 * Ação: 
	 * @author Marcos
	 */
	public void digitaCelular(String celular) {
		this.editElement(Attribute.id, "celular", celular);
	}
	/**
	 * Ação: 
	 * @author Marcos
	 */
	public void digitaEmail(String email) {
		this.editElement(Attribute.id, "email", email);
	}
	/**
	 * Ação: 
	 * @author Marcos
	 */
	public void selecionaClienteAutorizaEnvioDeInfoPorEmail(boolean checado) {
		
	}

}
