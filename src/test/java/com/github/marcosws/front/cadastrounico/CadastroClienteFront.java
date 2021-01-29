package com.github.marcosws.front.cadastrounico;

import com.github.marcosws.core.BasePage;
import com.github.marcosws.core.DriverFactory;
import com.github.marcosws.core.LogTest;

public class CadastroClienteFront extends BasePage {
	
	LogTest logTest = new LogTest();
	
	public CadastroClienteFront() {
		this.setDriver(DriverFactory.getDriver());
		this.setHighLight(true);
	}
	
	public void clicaAbaCadastro() {
		logTest.LogInfo("Clicando na Aba Cadastro");
		this.clickElement(Attribute.id, "aba-cadastro");
	}
	
	
	public String validaTitulo() {
		logTest.LogInfo("Validando o Titulo");
		return this.getTextElement(Attribute.tagName, "h2");
	}
	/**
	 * Seleciona Radio Button Pessoa Física
	 * @author Marcos
	 */
	public void selecionaPessoaFisica() {
		logTest.LogInfo("Selecionando Pessoa Física");
		this.clickElement(Attribute.id, "radio1");
	}
	/**
	 * Seleciona Radio Button Pessoa Jurídica
	 * @author Marcos
	 */
	public void selecionaPessoaJuridica() {
		logTest.LogInfo("Selecionando Pessoa Jurídica");
		this.clickElement(Attribute.id, "radio2");
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaNome(String nome) {
		logTest.LogInfo("Digitando Nome " + nome);
		this.editElement(Attribute.id, "nome", nome);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaCpf(String cpf) {
		logTest.LogInfo("Digitando CPF: " + cpf);
		this.editElement(Attribute.id, "cpf", cpf);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaNomeFantasia(String nomeFantasia) {
		logTest.LogInfo("Digitando a Nome Fantasia: " + nomeFantasia);
		this.editElement(Attribute.id, "nome-fantasia", nomeFantasia);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaRazaoSocial(String razaoSocial) {
		logTest.LogInfo("Digitando a Razão Social " + razaoSocial);
		this.editElement(Attribute.id, "razao-social",  razaoSocial);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaCnpj(String cnpj) {
		logTest.LogInfo("Digitando CNPJ: " + cnpj);
		this.editElement(Attribute.id, "cnpj", cnpj);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaTelefone(String telefone) {
		logTest.LogInfo("Digitando o Telefone: " + telefone);
		this.editElement(Attribute.id, "telefone", telefone);
	}
	/**
	 * Digita o Nome no campo texto.  
	 * @author Marcos
	 */
	public void digitaCelular(String celular) {
		logTest.LogInfo("Digitando o Celular: " + celular);
		this.editElement(Attribute.id, "celular", celular);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void digitaEmail(String email) {
		logTest.LogInfo("Digitando o Email: " + email);
		this.editElement(Attribute.id, "email", email);
	}
	/**
	 * Digita o Nome no campo texto. 
	 * @author Marcos
	 */
	public void selecionaClienteAutorizaEnvioDeInfoPorEmail(boolean checado) {
		logTest.LogInfo("Selecionando o Checkbox: Cliente Autoriza Envio De Informações Por Email, valor: " + checado);
		if(checado != this.ckeckedElement(Attribute.id, "autorizacao")) {
			this.clickElement(Attribute.xpath, "/html/body/doctype/div/div[2]/div[3]/form[1]/label[7]/span");
		}
	}
	
	public void clicarCadastrar() {
		logTest.LogInfo("Clicar em Cadastrar");
		this.clickElement(Attribute.id, "cadastrar");
	}
	
	public void clicarLimpar() {
		logTest.LogInfo("Clicar em Limpar");
		this.clickElement(Attribute.id, "limpar");
	}
	
	public String validaTextoNome() {
		logTest.LogInfo("Validando o Texto Nome");
		return this.getValueElement(Attribute.id, "nome");
	}
	public String validaTextoCpf() {
		logTest.LogInfo("Validando o Texto CPF");
		return this.getValueElement(Attribute.id, "cpf");
	}
	public String validaTextoNomeFantasia() {
		logTest.LogInfo("Validando o Texto Nome Fantasia");
		return this.getValueElement(Attribute.id, "nome-fantasia");
	}
	public String validaTextoRazaoSocial() {
		logTest.LogInfo("Validando o Texto Razão Social");
		return this.getValueElement(Attribute.id, "razao-social");
	}
	public String validaTextoCnpj() {
		logTest.LogInfo("Validando o Texto CNPJ");
		return this.getValueElement(Attribute.id, "cnpj");
	}
	public String validaTextoTelefone() {
		logTest.LogInfo("Validando o Texto Telefone");
		return this.getValueElement(Attribute.id, "telefone");
	}
	public String validaTextoCelular() {
		logTest.LogInfo("Validando o Texto Celular");
		return this.getValueElement(Attribute.id, "celular");
	}
	public String validaTextoEmail() {
		logTest.LogInfo("Validando o Texto Email");
		return this.getValueElement(Attribute.id, "email");
	}
	
	public String validaTextoMensagem(boolean aceitarMsg) {
		logTest.LogInfo("Validando o Texto da Mensagem, aceita mensagem: " + aceitarMsg);
		return this.dialogBox(aceitarMsg);
	}
	
	public String validaCampoNome() {
		logTest.LogInfo("Recuperando o Campo: Nome");
		return this.getTextElement(Attribute.id, "label-nome");
	}
	
	public String validaCampoCpf() {
		logTest.LogInfo("Recuperando o Campo: CPF");
		return this.getTextElement(Attribute.id, "label-cpf");
	}
	
	public String validaCampoNomeFantasia() {
		logTest.LogInfo("Recuperando o Campo: Nome Fantasia");
		return this.getTextElement(Attribute.id, "label-nome-fantasia");
	}
	
	public String validaCampoRazaoSocial() {
		logTest.LogInfo("Recuperando o Campo: Razão Social");
		return this.getTextElement(Attribute.id, "label-razao-social");
	}
	
	public String validaCampoCnpj() {
		logTest.LogInfo("Recuperando o Campo: CNPJ");
		return this.getTextElement(Attribute.id, "label-cnpj");
	}
	
	public String validaCampoTelefone() {
		logTest.LogInfo("Recuperando o Campo: Telefone");
		return this.getTextElement(Attribute.id, "label-telefone");
	}
	
	public String validaCampoCelular() {
		logTest.LogInfo("Recuperando o Campo: Celular");
		return this.getTextElement(Attribute.id, "label-celular");
	}
	
	public String validaCampoEmail() {
		logTest.LogInfo("Recuperando o Campo: Email");
		return this.getTextElement(Attribute.id, "label-email");
	}
	
	public String validaCampoClienteAutorizaEnvioDeInformacoesPorEmail() {
		logTest.LogInfo("Validando o Checkbox: Cliente Autoriza Envio De Informações Por Email");
		return this.getTextElement(Attribute.id, "label-autorizacao");
	}
	
	public void clicarVoltar() {
		logTest.LogInfo("Clicando em Voltar");
		this.clickElement(Attribute.id, "voltar");
	}
	
	public String statusNome() {
		logTest.LogInfo("Recuperando o Status do Nome");
		return this.getTextElement(Attribute.id, "status-nome");
	}
	
	public String statusCpf() {
		logTest.LogInfo("Recuperando o Status do CPF");
		return this.getTextElement(Attribute.id, "status-cpf");
	}
	
	public String  statusNomeFantasia() {
		logTest.LogInfo("Recuperando o Status do Nome Fantasia");
		return this.getTextElement(Attribute.id, "status-nome-fantasia");
	}
	
	public String statusRazaoSocial() {
		logTest.LogInfo("Recuperando o Status da Razão Social");
		return this.getTextElement(Attribute.id, "status-razao-social");
	}
	
	public String statusCnpj() {
		logTest.LogInfo("Recuperando o Status do CNPJ");
		return this.getTextElement(Attribute.id, "status-cnpj");
	}
	
	public String statusTelefone() {
		logTest.LogInfo("Recuperando o Status do Telefone");
		return this.getTextElement(Attribute.id, "status-telefone");
	}
	
	public String statusCelular() {
		logTest.LogInfo("Recuperando o Status do Celular");
		return this.getTextElement(Attribute.id, "status-celular");
	}
	
	public String statusEmail() {
		logTest.LogInfo("Recuperando o Status do Email");
		return this.getTextElement(Attribute.id, "status-email");
	}

}
