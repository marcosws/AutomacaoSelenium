package com.github.marcosws.nav.cadastrounico;

import com.github.marcosws.base.cadastrounico.CadastroCliente;
import com.github.marcosws.base.cadastrounico.TipoDeCadastro;
import com.github.marcosws.front.cadastrounico.CadastroClienteFront;
import com.github.marcosws.core.Validation;
import com.github.marcosws.utils.Common;

public class CadastroClienteNav {
	
	CadastroCliente cadastroCliente = new CadastroCliente();
	CadastroClienteFront cadastroClienteFront = new CadastroClienteFront();
	
	public void executaCadastroCliente(String nomeClasse) {
		
		Validation validacao = new Validation();
		cadastroCliente.carregaMassa(nomeClasse);
		
		this.preencheCadastro();
		
		if(!(cadastroCliente.isCadastrar() ^ cadastroCliente.isLimpar())) {
			validacao.falha("O Botão Cadastrar está como [" + cadastroCliente.isCadastrar() + "] e o Botão Limpar está como [" + cadastroCliente.isLimpar() + "], Deve estar um como Verdadeiro eo outro Falso no arquivo json.");
		}
		else if(cadastroCliente.isCadastrar()) {
			
			cadastroClienteFront.clicarCadastrar();
			if(cadastroCliente.isValidaMensagem()) {
				if(cadastroCliente.getAceitarMensagem().equalsIgnoreCase("Não")){
					this.validaMensagem(false);
				}
				else {
					this.validaMensagem(true);
				}
			}
			
			if((cadastroCliente.isValidarCadastro() ^ cadastroCliente.isValidarStatus())) {
				validacao.falha("O Validação do Cadastro está como [" + cadastroCliente.isValidarCadastro() + "] e a Validação do Status está como [" + cadastroCliente.isValidarStatus() + "], Deve estar um como Verdadeiro e o outro Falso no arquivo json.");
			}
			else if(cadastroCliente.isValidarCadastro()) {
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
					this.validaCamposCadastroVazio(false);
				}
				else {
					this.validaMensagem(true);
					this.validaCamposCadastroVazio(true);
				}
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
		
		if(vazio) {
			
		}
		else {
			
		}
		
	}
	
	private void validaMensagem(boolean aceitarMsg) {
		Validation validacao = new Validation();
		validacao.validaTexto(cadastroCliente.getTextoMensagem(), cadastroClienteFront.validaTextoMensagem(aceitarMsg).replace("\n", ""), "Validação Mensagem da Caixa de Dialogo");
	}
	
	private void validaCampo(String esperado, String gerado, String rotulo) {
		Validation validacao = new Validation();
		if(!esperado.isEmpty())
			validacao.validaTexto(esperado, gerado, rotulo);
	}
	
}
