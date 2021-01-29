package com.github.marcosws.nav.campotreinamento;

import com.github.marcosws.core.Validation;
import com.github.marcosws.front.campotreinamento.EmpresasFront;


public class EmpresasNav {
	
	public void executaEmpresas(String nomeClasse) {
		
		Validation validacao = new Validation();
		EmpresasFront empresasFront = new EmpresasFront();

	
		//geral.carregaMassa(nomeClasse);
		
		validacao.validaTexto("Empresas", empresasFront.validaTitulo(), "Titulo da Tela: Empresas");
		
	}

}
