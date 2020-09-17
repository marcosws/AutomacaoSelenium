package com.github.marcosws.nav.cadastrounico;

import com.github.marcosws.base.cadastrounico.CadastroCliente;
import com.github.marcosws.front.cadastrounico.CadastroClienteFront;
import com.github.marcosws.core.Validation;
import com.github.marcosws.utils.Common;

public class CadastroClienteNav {
	

	
	public void executaCadastroCliente(String nomeClasse) {
		
		CadastroCliente cadastroCliente = new CadastroCliente();
		Common common = new Common();
		
		cadastroCliente.carregaMassa(nomeClasse);
		
		CadastroClienteFront cadastroClienteFront = new CadastroClienteFront();
		
		Validation validacao = new Validation();
		validacao.validaTexto("Cadastro de Cliente", cadastroClienteFront.validaTitulo(), "Titulo da Tela: Cadastro de Cliente");
		
		System.out.println(cadastroCliente.getTipoDeCadastro());
		if(cadastroCliente.getTipoDeCadastro().equalsIgnoreCase("Pessoa Física")) {
			
			cadastroClienteFront.selecionaPessoaFisica();
			cadastroClienteFront.digitaNome(cadastroCliente.getNome());
			cadastroClienteFront.digitaCpf(cadastroCliente.getCpf());
			
		}
		else if(cadastroCliente.getTipoDeCadastro().equalsIgnoreCase("Pessoa Jurídica")) {
			
			cadastroClienteFront.selecionaPessoaJuridica();
			cadastroClienteFront.digitaNomeFantasia(cadastroCliente.getNomeFantasia());
			cadastroClienteFront.digitaRazaoSocial(cadastroCliente.getRazaoSocial());
			cadastroClienteFront.digitaCnpj(cadastroCliente.getCnpj());
			
		}
		
		cadastroClienteFront.digitaTelefone(cadastroCliente.getTelefone());
		cadastroClienteFront.digitaCelular(cadastroCliente.getCelular());
		cadastroClienteFront.digitaEmail(cadastroCliente.getEmail());
		cadastroClienteFront.selecionaClienteAutorizaEnvioDeInfoPorEmail(cadastroCliente.isClienteAutorizaIPEmail());
		
		if(cadastroCliente.isCadastrar()) {
			
			cadastroClienteFront.clicarCadastrar();
			
			if(cadastroCliente.isValidaMensagem()) {
				
				validacao.validaTexto(cadastroCliente.getTextoMensagem(), cadastroClienteFront.validaTextoMensagem(), "Validação Mensagem da Caixa de Dialogo");
				
			}
			
			if(cadastroCliente.getTipoDeCadastro().equals("Pessoa Física")) {
				
				validacao.validaTexto(cadastroCliente.getNome(), cadastroClienteFront.validaCampoNome().replace("Nome: ", ""), "");
				validacao.validaTexto(cadastroCliente.getCpf(), common.removeMask(cadastroClienteFront.validaCampoCpf().replace("CPF: ", "")), "");
				
			}
			else if(cadastroCliente.getTipoDeCadastro().equals("Pessoa Jurídica")){
				
				validacao.validaTexto(cadastroCliente.getNomeFantasia(), cadastroClienteFront.validaCampoNomeFantasia().replace("Nome Fantasia: ", ""), "");
				validacao.validaTexto(cadastroCliente.getRazaoSocial(), cadastroClienteFront.validaCampoRazaoSocial().replace("Razão Social: ", ""), "");
				validacao.validaTexto(cadastroCliente.getCnpj(), common.removeMask(cadastroClienteFront.validaCampoCnpj().replace("CNPJ: ", "")), "");
				
			}
			
			validacao.validaTexto(cadastroCliente.getTelefone(), common.removeMask(cadastroClienteFront.validaCampoTelefone().replace("Telefone: ", "")), "");
			validacao.validaTexto(cadastroCliente.getCelular(), common.removeMask(cadastroClienteFront.validaCampoCelular().replace("Celular: ", "")), "");
			validacao.validaTexto(cadastroCliente.getEmail(), cadastroClienteFront.validaCampoEmail().replace("E-mail: ", ""), "");
		
			String autorizacao = (cadastroCliente.isClienteAutorizaIPEmail()) ? "Sim" : "Não";
			validacao.validaTexto(autorizacao, cadastroClienteFront.validaCampoClienteAutorizaEnvioDeInformacoesPorEmail().replace("Cliente autoriza envio de informações por E-mail: ", ""), "");
			
			cadastroClienteFront.clicarVoltar();
			
		}
		else if(cadastroCliente.isLimpar()) {
			
			cadastroClienteFront.clicarLimpar();
			
			/*
			 * Validação dos Campos em Branco (Vazios após clicar em limpar)
			 */
		}
	}
	
}
