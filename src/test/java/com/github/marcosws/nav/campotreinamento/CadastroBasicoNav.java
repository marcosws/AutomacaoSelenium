package com.github.marcosws.nav.campotreinamento;

import com.github.marcosws.base.campotreinamento.CadastroBasico;

public class CadastroBasicoNav {
	
	public void executaCadastroBasico(String nomeClasse) {
		
		CadastroBasico cadastroBasico = new CadastroBasico();
		cadastroBasico.carregaMassa(nomeClasse);
		
		System.out.println(cadastroBasico.getNome());
		System.out.println(cadastroBasico.getEndereco());
		System.out.println(cadastroBasico.getCep());
		
		
	}

}
