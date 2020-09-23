package com.github.marcosws.nav.cadastrounico;

import com.github.marcosws.base.cadastrounico.CadastroCliente;
import com.github.marcosws.base.cadastrounico.TipoDeCadastro;
import com.github.marcosws.front.cadastrounico.CadastroClienteFront;
import com.github.marcosws.core.Validation;
import com.github.marcosws.utils.Common;

public class CadastroClienteNav {
	
	public void executaCadastroCliente(String nomeClasse) {
		
		CadastroCliente cadastroCliente = new CadastroCliente();
		CadastroClienteFront cadastroClienteFront = new CadastroClienteFront();
		Common common = new Common();
		
		cadastroCliente.carregaMassa(nomeClasse);
		cadastroClienteFront.clicaAbaCadastro();
		
		Validation validacao = new Validation();
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
		
		if(cadastroCliente.isCadastrar()) {
			
			cadastroClienteFront.clicarCadastrar();
			
			if(cadastroCliente.isValidaMensagem()) {
				
				if(cadastroCliente.getTextoMensagem().equals("")) {
					
					if(cadastroCliente.getTipoDeCadastro().equals(TipoDeCadastro.PESSOA_FISICA.getValor())) {
						
						if(!cadastroCliente.getStatusNome().isEmpty())
							validacao.validaTexto(cadastroCliente.getStatusNome(), cadastroClienteFront.statusNome(),"Status Nome");
						
						if(!cadastroCliente.getStatusCpf().isEmpty())
							validacao.validaTexto(cadastroCliente.getStatusCpf(), cadastroClienteFront.statusCpf(),"Status CPF");
						
					}
					else if(cadastroCliente.getTipoDeCadastro().equals(TipoDeCadastro.PESSOA_JURIDICA.getValor())) {
						
						if(!cadastroCliente.getStatusNomeFantasia().isEmpty())
							validacao.validaTexto(cadastroCliente.getStatusNomeFantasia(), cadastroClienteFront.statusNomeFantasia(),"Status Nome Fantasia");
						
						if(!cadastroCliente.getStatusRazaoSocial().isEmpty())
							validacao.validaTexto(cadastroCliente.getStatusRazaoSocial(), cadastroClienteFront.statusRazaoSocial(),"Status Razão Social");
						
						if(!cadastroCliente.getStatusCnpj().isEmpty())
							validacao.validaTexto(cadastroCliente.getStatusCnpj(), cadastroClienteFront.statusCnpj(),"Status CNPJ");
						
					}
					
					if(!cadastroCliente.getStatusTelefone().isEmpty())
						validacao.validaTexto(cadastroCliente.getStatusTelefone(), cadastroClienteFront.statusTelefone(),"Status Telefone");
					
					if(!cadastroCliente.getStatusCelular().isEmpty())
						validacao.validaTexto(cadastroCliente.getStatusCelular(), cadastroClienteFront.statusCelular(),"Status Celular");
					
					if(!cadastroCliente.getStatusEmail().isEmpty())
						validacao.validaTexto(cadastroCliente.getStatusEmail(), cadastroClienteFront.statusEmail(),"Status E-mail");
					
				}
				else {
					
					validacao.validaTexto(cadastroCliente.getTextoMensagem(), cadastroClienteFront.validaTextoMensagem().replace("\n", ""), "Validação Mensagem da Caixa de Dialogo");
					
				}
				
				common.sleep(6000);
				
			}
			else {
				
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
			
		}
		else if(cadastroCliente.isLimpar()) {
			
			cadastroClienteFront.clicarLimpar();
			
			/*
			 * Validação dos Campos em Branco (Vazios após clicar em limpar)
			 */
		}
	}
	
}
