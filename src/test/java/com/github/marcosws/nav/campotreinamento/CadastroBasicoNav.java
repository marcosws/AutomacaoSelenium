package com.github.marcosws.nav.campotreinamento;

import com.github.marcosws.base.campotreinamento.CadastroBasico;
import com.github.marcosws.front.campotreinamento.CadastroBasicoFront;
import com.github.marcosws.utils.Common;

public class CadastroBasicoNav {
	
	public void executaCadastroBasico(String nomeClasse) {
		
		CadastroBasico cadastroBasico = new CadastroBasico();
		CadastroBasicoFront cadastroBasicoFront = new CadastroBasicoFront();
		Common common = new Common();
		
		cadastroBasico.carregaMassa(nomeClasse);
		
		cadastroBasicoFront.digitaNome(cadastroBasico.getNome());
		cadastroBasicoFront.digitaEndereco(cadastroBasico.getEndereco());
		cadastroBasicoFront.digitaNumero(cadastroBasico.getNumero());
		cadastroBasicoFront.digitaCep(cadastroBasico.getCep());
		
		if(cadastroBasico.getProfissao().equalsIgnoreCase("estudante")) {
			cadastroBasicoFront.selecionaEstudante(true);
		}
		else if(cadastroBasico.getProfissao().equalsIgnoreCase("profissional clt")) {
			cadastroBasicoFront.selecionaProfissionalClt(true);
		}
		else if(cadastroBasico.getProfissao().equalsIgnoreCase("empresário")) {
			cadastroBasicoFront.selecionaEmpresario(true);
		}
		
		cadastroBasicoFront.selecionaPossuiCarro(common.checkValue(cadastroBasico.getCarro()));
		cadastroBasicoFront.selecionaPossuiMoto(common.checkValue(cadastroBasico.getMoto()));
		cadastroBasicoFront.selecionaPossuiUtilitario(common.checkValue(cadastroBasico.getUtilitario()));
		
		cadastroBasicoFront.selecionaMontadora(cadastroBasico.getMontadora());
		
		cadastroBasicoFront.clicaContinuar();

		
	}

}
