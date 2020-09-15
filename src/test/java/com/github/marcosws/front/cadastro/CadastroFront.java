package com.github.marcosws.front.cadastro;

import com.github.marcosws.core.BasePage;
import com.github.marcosws.core.DriverFactory;

public class CadastroFront extends BasePage {
	
	public CadastroFront() {
		this.setDriver(DriverFactory.getDriver());
		this.setHighLight(true);
	}
	/**
	 * A��o: Seleciona Radio Button Pessoa F�sica
	 * @author Marcos
	 */
	public void selecionaPessoaFisica() {
		this.clickElement(Attribute.id, "radio1");
	}
	/**
	 * A��o: Seleciona Radio Button Pessoa Jur�dica
	 * @author Marcos
	 */
	public void selecionaPessoaJuridica() {
		this.clickElement(Attribute.id, "radio2");
	}
	/**
	 * A��o: 
	 * @author Marcos
	 */
	public void digitaNome(String nome) {
		this.editElement(Attribute.id, "nome", nome);
	}
	/**
	 * A��o: 
	 * @author Marcos
	 */
	public void digitaCpf(String cpf) {
		this.editElement(Attribute.id, "cpf", cpf);
	}
	/**
	 * A��o: 
	 * @author Marcos
	 */
	public void digitaNomeFantasia(String nomeFantasia) {
		this.editElement(Attribute.id, "nomeFantasia", nomeFantasia);
	}
	/**
	 * A��o: 
	 * @author Marcos
	 */
	public void digitaRazaoSocial(String razaoSocial) {
		this.editElement(Attribute.id, "razaoSocial",  razaoSocial);
	}
	/**
	 * A��o: 
	 * @author Marcos
	 */
	public void digitaCnpj(String cnpj) {
		this.editElement(Attribute.id, "cnpj", cnpj);
	}
	/**
	 * A��o: 
	 * @author Marcos
	 */
	public void digitaTelefone(String telefone) {
		this.editElement(Attribute.id, "telefone", telefone);
	}
	/**
	 * A��o: 
	 * @author Marcos
	 */
	public void digitaCelular(String celular) {
		this.editElement(Attribute.id, "celular", celular);
	}
	/**
	 * A��o: 
	 * @author Marcos
	 */
	public void digitaEmail(String email) {
		this.editElement(Attribute.id, "email", email);
	}
	/**
	 * A��o: 
	 * @author Marcos
	 */
	public void selecionaClienteAutorizaEnvioDeInfoPorEmail(boolean checado) {
		
	}

}
