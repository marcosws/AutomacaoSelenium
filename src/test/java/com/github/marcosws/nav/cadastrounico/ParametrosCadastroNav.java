package com.github.marcosws.nav.cadastrounico;

import com.github.marcosws.base.cadastrounico.MensagemDeInconsistencia;
import com.github.marcosws.base.cadastrounico.ParametrosCadastro;
import com.github.marcosws.core.Validation;
import com.github.marcosws.front.cadastrounico.ParametrosCadastroFront;

public class ParametrosCadastroNav {
	
	public void executaParametrosCadastro(String nomeClasse) {
	

		ParametrosCadastro parametrosCadastro = new ParametrosCadastro();
		ParametrosCadastroFront parametrosCadastroFront = new ParametrosCadastroFront();
		
		parametrosCadastro.carregaMassa(nomeClasse);
		parametrosCadastroFront.clicaAbaParametros();
		
		Validation validacao = new Validation();
		validacao.validaTexto("Parâmetros do Cadastro", parametrosCadastroFront.validaTitulo(), "Titulo da Tela: Parâmetros do Cadastro");
		
		if(parametrosCadastro.getMensagemDeInconsistencia().equals(MensagemDeInconsistencia.APRESENTAR_CAIXA_DE_DIALOGO.getValor())) {
			parametrosCadastroFront.selecionaApresentarCaixaDeDialogo();
		}
		else if(parametrosCadastro.getMensagemDeInconsistencia().equals(MensagemDeInconsistencia.APRESENTAR_LABEL_INFORMATIVA.getValor())) {
			parametrosCadastroFront.selecionaApresentarLabelInformativa();
		}
		
		parametrosCadastroFront.selecionaApresentarMensagemDeConfirmacaoDeCadastro(parametrosCadastro.isApresentarMensagemDeconfirmacaoDeCadastro());
		
		parametrosCadastroFront.selecionaApresentarMensagemDeConfirmacaoAntesDeLimparOsCampos(parametrosCadastro.isApresentarMensagemDeconfirmacaoAntesDeLimparOsCampos());
		
	
	}

}
