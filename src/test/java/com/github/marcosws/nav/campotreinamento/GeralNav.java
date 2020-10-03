package com.github.marcosws.nav.campotreinamento;


import com.github.marcosws.base.campotreinamento.Geral;
import com.github.marcosws.core.Validation;
import com.github.marcosws.front.campotreinamento.GeralFront;
import com.github.marcosws.utils.Common;


public class GeralNav {
	
	public void executaGeral(String nomeClasse) {
		
		Geral geral = new Geral();
		GeralFront geralFront = new GeralFront();
		Validation validacao = new Validation();
		Common common = new Common();
	
		geral.carregaMassa(nomeClasse);
		
		validacao.validaTexto("Geral", geralFront.validaTitulo(), "Titulo da Tela: Geral");
		
		geralFront.selecionaEstado(geral.getEstado());
		
		geralFront.selecionaNivel(geral.getNivel());
		
		geralFront.selecionaPercentual1(geral.getPercentual1());
		
		geralFront.selecionaPercentual2(geral.getPercentual2());
		
		geralFront.clicaAlert();
		validacao.validaTexto(geral.getMensagemAlert(), geralFront.validaAlert(),"Alert");
		
		geralFront.clicaConfirm();
		validacao.validaTexto(geral.getMensagemConfirm(), geralFront.validaConfirm(common.checkValue(geral.getAceitaConfirm())),"Confirm");
		
		geralFront.clicaPrompt();
		validacao.validaTexto(geral.getMensagemPrompt(), geralFront.validaPrompt(common.checkValue(geral.getAceitaPrompt()), geral.getTextoPrompt()),"Prompt");
		
		geralFront.clicaContinuar();
		
		
	}

}
