package com.github.marcosws.nav.cadastrounico;

import com.github.marcosws.base.cadastrounico.CadastroCliente;
import com.github.marcosws.base.cadastrounico.TipoDeCadastro;
import com.github.marcosws.front.cadastrounico.CadastroClienteFront;
import com.github.marcosws.core.LogTest;
import com.github.marcosws.core.Validation;
import com.github.marcosws.utils.Common;

public class CadastroClienteNav {
	
	CadastroCliente cadastroCliente = new CadastroCliente();
	CadastroClienteFront cadastroClienteFront = new CadastroClienteFront();
	
	public void executaCadastroCliente(String nomeClasse) {
		
		cadastroCliente.carregaMassa(nomeClasse);
		LogTest logTest = new LogTest();
		
		this.preencheCadastro();
		
		if(!(cadastroCliente.isCadastrar() ^ cadastroCliente.isLimpar())) {
			logTest.LogFail("O Botão Cadastrar está como [" + cadastroCliente.isCadastrar() + "] e o Botão Limpar está como [" + cadastroCliente.isLimpar() + "], Deve estar um como Verdadeiro eo outro Falso no arquivo json.");
		}
		else if(cadastroCliente.isCadastrar()) {
			
			cadastroClienteFront.clicarCadastrar();
			if(cadastroCliente.isValidaMensagem()) {
				if(cadastroCliente.getAceitarMensagem().equalsIgnoreCase("Não")){
					this.validaMensagem(false);
					logTest.LogInfo("Validação - Opção da Mensagem: [" + cadastroCliente.getAceitarMensagem() + "]");
				} 
				else if(cadastroCliente.getAceitarMensagem().equalsIgnoreCase("Sim")){
					this.validaMensagem(true);
					logTest.LogInfo("Validação - Opção da Mensagem: [" + cadastroCliente.getAceitarMensagem() + "]");
				}
				else {
					this.validaMensagem(true);
				}
			}
			
			if(cadastroCliente.isValidarCadastro()) {
				this.validaCadastro();
			}
			else if(cadastroCliente.isValidarStatus()) {
				this.validaStatus();
			}
			
		}
		else if(cadastroCliente.isLimpar()) {
			
			cadastroClienteFront.clicarLimpar();
			
			if(cadastroCliente.isValidaMensagem()) {
				if(cadastroCliente.getAceitarMensagem().equalsIgnoreCase("Não")){
					this.validaMensagem(false);
					logTest.LogInfo("Validação - Opção da Mensagem: [" + cadastroCliente.getAceitarMensagem() + "]");
					this.validaCamposCadastroVazio(false);
				}
				else {
					this.validaMensagem(true);
					logTest.LogInfo("Validação - Opção da Mensagem: [" + cadastroCliente.getAceitarMensagem() + "]");
					this.validaCamposCadastroVazio(true);
				}
			}
			else {
				this.validaCamposCadastroVazio(true);
			}
			
		}
		
	}
	
	private void preencheCadastro() {
		
		Validation validacao = new Validation();
		
		cadastroClienteFront.clicaAbaCadastro();
		validacao.validaTexto("Cadastro de Cliente", cadastroClienteFront.validaTitulo(), "Titulo da Tela: Cadastro de Cliente");
		
		if(cadastroCliente.getTipoDeCadastro().equals(TipoDeCadastro.PESSOA_FISICA.getValor())) {
			
			cadastroClienteFront.selecionaPessoaFisica();
			cadastroClienteFront.digitaNome(cadastroCliente.getNome());
			cadastroClienteFront.digitaCpf(cadastroCliente.getCpf());
			
		}
		
		else if(cadastroCliente.getTipoDeCadastro().equalsIgnoreCase(TipoDeCadastro.PESSOA_JURIDICA.getValor())) {
			
			cadastroClienteFront.selecionaPessoaJuridica();
			cadastroClienteFront.digitaNomeFantasia(cadastroCliente.getNomeFantasia());
			cadastroClienteFront.digitaRazaoSocial(cadastroCliente.getRazaoSocial());
			cadastroClienteFront.digitaCnpj(cadastroCliente.getCnpj());
			
		}
		
		cadastroClienteFront.digitaTelefone(cadastroCliente.getTelefone());
		cadastroClienteFront.digitaCelular(cadastroCliente.getCelular());
		cadastroClienteFront.digitaEmail(cadastroCliente.getEmail());
		cadastroClienteFront.selecionaClienteAutorizaEnvioDeInfoPorEmail(cadastroCliente.isClienteAutorizaIPEmail());
		
	}
	
	private void validaCadastro() {
		
		Validation validacao = new Validation();
		Common common = new Common();
		
		if(cadastroCliente.getTipoDeCadastro().equals(TipoDeCadastro.PESSOA_FISICA.getValor())) {
			validacao.validaTexto(cadastroCliente.getNome(), cadastroClienteFront.validaCampoNome().replace("Nome: ", ""), "Nome");
			validacao.validaTexto(cadastroCliente.getCpf(), common.removeMask(cadastroClienteFront.validaCampoCpf().replace("CPF: ", "")), "CPF");
		}
		else if(cadastroCliente.getTipoDeCadastro().equals(TipoDeCadastro.PESSOA_JURIDICA.getValor())){
			validacao.validaTexto(cadastroCliente.getNomeFantasia(), cadastroClienteFront.validaCampoNomeFantasia().replace("Nome Fantasia: ", ""), "Nome Fantasia");
			validacao.validaTexto(cadastroCliente.getRazaoSocial(), cadastroClienteFront.validaCampoRazaoSocial().replace("Razão Social: ", ""), "Razão Social");
			validacao.validaTexto(cadastroCliente.getCnpj(), common.removeMask(cadastroClienteFront.validaCampoCnpj().replace("CNPJ: ", "")), "CNPJ");
		}
		validacao.validaTexto(cadastroCliente.getTelefone(), (common.removeMask(cadastroClienteFront.validaCampoTelefone().replace("Telefone:", ""))).trim(), "Telefone");
		validacao.validaTexto(cadastroCliente.getCelular(), (common.removeMask(cadastroClienteFront.validaCampoCelular().replace("Celular:", ""))).trim(), "Celular");
		validacao.validaTexto(cadastroCliente.getEmail(), (cadastroClienteFront.validaCampoEmail().replace("E-mail:", "")).trim(), "E-Mail");
		String autorizacao = (cadastroCliente.isClienteAutorizaIPEmail()) ? "Sim" : "Não";
		validacao.validaTexto(autorizacao, cadastroClienteFront.validaCampoClienteAutorizaEnvioDeInformacoesPorEmail().replace("Cliente autoriza envio de informações por E-mail: ", ""), "Cliente autoriza envio de informações por E-mail");
		cadastroClienteFront.clicarVoltar();
		
	}
	
	private void validaStatus() {
		
		if(cadastroCliente.getTipoDeCadastro().equals(TipoDeCadastro.PESSOA_FISICA.getValor())) {
		
			this.validaCampo(cadastroCliente.getStatusNome(), cadastroClienteFront.statusNome(),"Status Nome");
			this.validaCampo(cadastroCliente.getStatusCpf(), cadastroClienteFront.statusCpf(),"Status CPF");
			
		}
		else if(cadastroCliente.getTipoDeCadastro().equals(TipoDeCadastro.PESSOA_JURIDICA.getValor())) {
			
			this.validaCampo(cadastroCliente.getStatusNomeFantasia(), cadastroClienteFront.statusNomeFantasia(),"Status Nome Fantasia");
			this.validaCampo(cadastroCliente.getStatusRazaoSocial(), cadastroClienteFront.statusRazaoSocial(),"Status Razão Social");
			this.validaCampo(cadastroCliente.getStatusCnpj(), cadastroClienteFront.statusCnpj(),"Status CNPJ");
		}
		
		this.validaCampo(cadastroCliente.getStatusTelefone(), cadastroClienteFront.statusTelefone(),"Status Telefone");
		this.validaCampo(cadastroCliente.getStatusCelular(), cadastroClienteFront.statusCelular(),"Status Celular");
		this.validaCampo(cadastroCliente.getStatusEmail(), cadastroClienteFront.statusEmail(),"Status E-mail");
	}
	
	private void validaCamposCadastroVazio(boolean vazio) {
		
		Validation validacao = new Validation();
		Common common = new Common();
		String strVazio = "";
		if(vazio) {
			
			if(cadastroCliente.getTipoDeCadastro().equals(TipoDeCadastro.PESSOA_FISICA.getValor())) {
				validacao.validaTexto(strVazio, cadastroClienteFront.validaTextoNome(), "Nome");
				validacao.validaTexto(strVazio, common.removeMask(cadastroClienteFront.validaTextoCpf()), "CPF");
			}
			else if(cadastroCliente.getTipoDeCadastro().equals(TipoDeCadastro.PESSOA_JURIDICA.getValor())){
				validacao.validaTexto(strVazio, cadastroClienteFront.validaTextoNomeFantasia(), "Nome Fantasia");
				validacao.validaTexto(strVazio, cadastroClienteFront.validaTextoRazaoSocial(), "Razão Social");
				validacao.validaTexto(strVazio, common.removeMask(cadastroClienteFront.validaTextoCnpj()), "CNPJ");
			}
			validacao.validaTexto(strVazio, common.removeMask(cadastroClienteFront.validaTextoTelefone()), "Telefone");
			validacao.validaTexto(strVazio, common.removeMask(cadastroClienteFront.validaTextoCelular()), "Celular");
			validacao.validaTexto(strVazio, cadastroClienteFront.validaTextoEmail(), "E-Mail");
			
			
			
		}
		else {
			if(cadastroCliente.getTipoDeCadastro().equals(TipoDeCadastro.PESSOA_FISICA.getValor())) {
				validacao.validaTexto(cadastroCliente.getNome(), cadastroClienteFront.validaTextoNome(), "Nome");
				validacao.validaTexto(cadastroCliente.getCpf(), common.removeMask(cadastroClienteFront.validaTextoCpf()), "CPF");
			}
			else if(cadastroCliente.getTipoDeCadastro().equals(TipoDeCadastro.PESSOA_JURIDICA.getValor())){
				validacao.validaTexto(cadastroCliente.getNomeFantasia(), cadastroClienteFront.validaTextoNomeFantasia(), "Nome Fantasia");
				validacao.validaTexto(cadastroCliente.getRazaoSocial(), cadastroClienteFront.validaTextoRazaoSocial(), "Razão Social");
				validacao.validaTexto(cadastroCliente.getCnpj(), common.removeMask(cadastroClienteFront.validaTextoCnpj()), "CNPJ");
			}
			validacao.validaTexto(cadastroCliente.getTelefone(), common.removeMask(cadastroClienteFront.validaTextoTelefone()), "Telefone");
			validacao.validaTexto(cadastroCliente.getCelular(), common.removeMask(cadastroClienteFront.validaTextoCelular()), "Celular");
			validacao.validaTexto(cadastroCliente.getEmail(), cadastroClienteFront.validaTextoEmail(), "E-Mail");

		}
		
	}
	
	private void validaMensagem(boolean aceitarMsg) {
		Validation validacao = new Validation();
		validacao.validaTexto(cadastroCliente.getTextoMensagem(), cadastroClienteFront.validaTextoMensagem(aceitarMsg).replace("\n", ""), "Validação Mensagem da Caixa de Dialogo");
	}
	
	private void validaCampo(String esperado, String gerado, String rotulo) {
		Validation validacao = new Validation();
		if(!esperado.equals(""))
			validacao.validaTexto(esperado, gerado, rotulo);
	}
	
}
