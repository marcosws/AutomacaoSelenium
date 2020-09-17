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
		
		DriverFactory.killDriver();
	}
	
	public void executaCadastro(String nomeClasse) {
		
		Cadastro cadastro = new Cadastro();
		Common common = new Common();
		
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
		else if(cadastro.getTipoDeCadastro().equalsIgnoreCase("Pessoa Jurídica")) {
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
			
			if(cadastro.getTipoDeCadastro().equals("Pessoa Física")) {
				validacao.validaTexto(cadastro.getNome(), cadastroFront.validaCampoNome().replace("Nome: ", ""), "");
				validacao.validaTexto(cadastro.getCpf(), common.removeMask(cadastroFront.validaCampoCpf().replace("CPF: ", "")), "");
			}
			else if(cadastro.getTipoDeCadastro().equals("Pessoa Jurídica")){
				validacao.validaTexto(cadastro.getNomeFantasia(), cadastroFront.validaCampoNomeFantasia(), "");
				validacao.validaTexto(cadastro.getRazaoSocial(), cadastroFront.validaCampoRazaoSocial(), "");
				validacao.validaTexto(cadastro.getStatusCnpj(), common.removeMask(cadastroFront.validaCampoCnpj().replace("CNPJ: ", "")), "");
			}
			
			validacao.validaTexto(cadastro.getTelefone(), common.removeMask(cadastroFront.validaCampoTelefone().replace("Telefone: ", "")), "");
			validacao.validaTexto(cadastro.getCelular(), common.removeMask(cadastroFront.validaCampoCelular().replace("Celular: ", "")), "");
			validacao.validaTexto(cadastro.getEmail(), cadastroFront.validaCampoEmail().replace("E-mail: ", ""), "");
		
			String autorizacao = (cadastro.isClienteAutorizaIPEmail()) ? "Sim" : "Não";
			validacao.validaTexto(autorizacao, cadastroFront.validaCampoClienteAutorizaEnvioDeInformacoesPorEmail().replace("Cliente autoriza envio de informações por E-mail: ", ""), "");
			
			cadastroFront.clicarVoltar();
			
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
