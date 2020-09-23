package com.github.marcosws.base.cadastrounico;

public enum TipoDeCadastro {
	
	PESSOA_FISICA("Pessoa Física"),  PESSOA_JURIDICA("Pessoa Jurídica");

	private final String valor;
	TipoDeCadastro(String tipoDeCadastro){
		valor = tipoDeCadastro;
	}
	
	public String getValor(){
		return valor;
	}

}
