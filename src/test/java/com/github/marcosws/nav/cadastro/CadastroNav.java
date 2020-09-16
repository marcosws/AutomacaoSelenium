package com.github.marcosws.nav.cadastro;

import com.github.marcosws.base.cadastro.Cadastro;
import com.github.marcosws.context.ContextApp;
import com.github.marcosws.core.DriverFactory;
import com.github.marcosws.core.DriverFactory.Browser;
import com.github.marcosws.core.Validation;
import com.github.marcosws.front.cadastro.CadastroFront;
import com.github.marcosws.utils.Common;

public class CadastroNav {
	
	public void iniciarCadastro() {

		DriverFactory.setNavigator(Browser.CHROME);
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().get(ContextApp.ADDRESS_PROTO_CAD);

	}
	
	public void finalizarCadastro() {
		
		Common common = new Common(); // REMOVER APÓS CONSTRUÇÃO
		common.sleep(7000);           // REMOVER APÓS CONSTRUÇÃO
		
		DriverFactory.killDriver();
	}
	
	public void executaCadastro(String nomeClasse) {
		
		Cadastro cadastro = new Cadastro();
		cadastro.carregaMassa(nomeClasse);
		
		CadastroFront cadastroFront = new CadastroFront();
		
		Validation validacao = new Validation();
		validacao.validaTexto("Cadastro de Cliente", cadastroFront.validaTitulo(), "Titulo da Tela: Cadastro de Cliente");
		
		System.out.println(cadastro.getTipoDeCadastro());
		if(cadastro.getTipoDeCadastro().equalsIgnoreCase("Pessoa Física")) {
			cadastroFront.selecionaPessoaFisica();
			cadastroFront.digitaNome(cadastro.getNome());
			cadastroFront.digitaCpf(cadastro.getCpf());
		}
		else if(cadastro.getTipoDeCadastro().equalsIgnoreCase("Pessoa Jur�dica")) {
			cadastroFront.selecionaPessoaJuridica();
			cadastroFront.digitaNomeFantasia(cadastro.getNomeFantasia());
			cadastroFront.digitaRazaoSocial(cadastro.getRazaoSocial());
			cadastroFront.digitaCnpj(cadastro.getCnpj());
		}
		
		cadastroFront.digitaTelefone(cadastro.getTelefone());
		cadastroFront.digitaCelular(cadastro.getCelular());
		cadastroFront.digitaEmail(cadastro.getEmail());
		cadastroFront.selecionaClienteAutorizaEnvioDeInfoPorEmail(cadastro.isClienteAutorizaIPEmail());
		
		if(cadastro.isCadastrar()) {
			
			cadastroFront.clicarCadastrar();
			
			if(cadastro.isValidaMensagem()) {
				validacao.validaTexto(cadastro.getTextoMensagem(), cadastroFront.validaTextoMensagem(), "Validação Mensagem da Caixa de Dialogo");
			}
			
			/*
			 * Validação dos Campos
			 */
			
		}
		else if(cadastro.isLimpar()) {
			
			cadastroFront.clicarLimpar();
			
			/*
			 * Validação dos Campos em Branco (Vazios após clicar em limpar)
			 */
		}
	}
	
	public void executaParametros(String nomeClasse) {
		
	}
}
