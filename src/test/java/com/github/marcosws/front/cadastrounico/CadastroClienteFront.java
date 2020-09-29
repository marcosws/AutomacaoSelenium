package com.github.marcosws.front.cadastrounico;

import com.github.marcosws.core.BasePage;
import com.github.marcosws.core.DriverFactory;

public class CadastroClienteFront extends BasePage {
	
	public CadastroClienteFront() {
		this.setDriver(DriverFactory.getDriver());
		this.setHighLight(true);
	}
	
	public void clicaAbaCadastro() {
		this.clickElement(Attribute.id, "aba-cadastro");
	}
	
	
	public String validaTitulo() {
		return this.getTextElement(Attribute.tagName, "h2");
	}
	/**
	 * Seleciona Radio Button Pessoa Física
	 * @author Marcos
	 */
	public void selecionaPessoaFisica() {
		this.clickElement(Attribute.id, "radio1");
	}
	/**
	 * Seleciona Radio Button Pessoa Jurídica
	 * @author Marcos
	 */
	public void selecionaPessoaJuridica() {
		this.clickElement(Attribute.id, "radio2");
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaNome(String nome) {
		this.editElement(Attribute.id, "nome", nome);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaCpf(String cpf) {
		this.editElement(Attribute.id, "cpf", cpf);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaNomeFantasia(String nomeFantasia) {
		this.editElement(Attribute.id, "nome-fantasia", nomeFantasia);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaRazaoSocial(String razaoSocial) {
		this.editElement(Attribute.id, "razao-social",  razaoSocial);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaCnpj(String cnpj) {
		this.editElement(Attribute.id, "cnpj", cnpj);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaTelefone(String telefone) {
		this.editElement(Attribute.id, "telefone", telefone);
	}
	/**
	 * Digita o Nome no campo texto.  
	 * @author Marcos
	 */
	public void digitaCelular(String celular) {
		this.editElement(Attribute.id, "celular", celular);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaEmail(String email) {
		this.editElement(Attribute.id, "email", email);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void selecionaClienteAutorizaEnvioDeInfoPorEmail(boolean checado) {
		if(checado != this.ckeckedElement(Attribute.id, "autorizacao")) {
			this.clickElement(Attribute.xpath, "/html/body/doctype/div/div[2]/div[3]/form[1]/label[7]/span");
		}
	}
	
	public void clicarCadastrar() {
		this.clickElement(Attribute.id, "cadastrar");
	}
	
	public void clicarLimpar() {
		this.clickElement(Attribute.id, "limpar");
	}
	
	public String validaTextoMensagem(boolean aceitarMsg) {
		return this.dialogBox(aceitarMsg);
	}
	
	public String validaCampoNome() {
		return this.getTextElement(Attribute.id, "label-nome");
	}
	
	public String validaCampoCpf() {
		return this.getTextElement(Attribute.id, "label-cpf");
	}
	
	public String validaCampoNomeFantasia() {
		return this.getTextElement(Attribute.id, "label-nome-fantasia");
	}
	
	public String validaCampoRazaoSocial() {
		return this.getTextElement(Attribute.id, "label-razao-social");
	}
	
	public String validaCampoCnpj() {
		return this.getTextElement(Attribute.id, "label-cnpj");
	}
	
	public String validaCampoTelefone() {
		return this.getTextElement(Attribute.id, "label-telefone");
	}
	
	public String validaCampoCelular() {
		return this.getTextElement(Attribute.id, "label-celular");
	}
	
	public String validaCampoEmail() {
		return this.getTextElement(Attribute.id, "label-email");
	}
	
	public String validaCampoClienteAutorizaEnvioDeInformacoesPorEmail() {
		return this.getTextElement(Attribute.id, "label-autorizacao");
	}
	
	public void clicarVoltar() {
		this.clickElement(Attribute.id, "voltar");
	}
	
	public String statusNome() {
		return this.getTextElement(Attribute.id, "status-nome");
	}
	
	public String statusCpf() {
		return this.getTextElement(Attribute.id, "status-cpf");
	}
	
	public String  statusNomeFantasia() {
		return this.getTextElement(Attribute.id, "status-nome-fantasia");
	}
	
	public String statusRazaoSocial() {
		return this.getTextElement(Attribute.id, "status-razao-social");
	}
	
	public String statusCnpj() {
		return this.getTextElement(Attribute.id, "status-cnpj");
	}
	
	public String statusTelefone() {
		return this.getTextElement(Attribute.id, "status-telefone");
	}
	
	public String statusCelular() {
		return this.getTextElement(Attribute.id, "status-celular");
	}
	
	public String statusEmail() {
		return this.getTextElement(Attribute.id, "status-email");
	}

}
