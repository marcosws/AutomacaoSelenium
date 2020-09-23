package com.github.marcosws.base.cadastrounico;

public enum MensagemDeInconsistencia {

	APRESENTAR_CAIXA_DE_DIALOGO("Apresentar caixa de dialogo"),  
	APRESENTAR_LABEL_INFORMATIVA("Apresentar label informativa");

	private final String valor;
	MensagemDeInconsistencia(String mensagemDeInconsistencia){
		valor = mensagemDeInconsistencia;
	}
	
	public String getValor(){
		return valor;
	}
	
}
