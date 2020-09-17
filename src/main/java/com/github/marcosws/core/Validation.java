package com.github.marcosws.core;

public class Validation {
	
	public void validaTexto(String esperado, String gerado, String rotulo){
		LogTest logTest = new LogTest();
		if(esperado.equals("") && gerado.equals("")){
			logTest.LogPass("A validação do campo: [" + rotulo + "] passou, o campo está vazio conforme esperado.");
		}
		else if(esperado.equals(gerado)){
			logTest.LogAssert("A validação do campo: [" + rotulo + "] passou, esperado: [" + esperado + "] e gerado: [" + gerado +"]", esperado, gerado);
		}
		else{
			logTest.LogAssert("A validação do campo: [" + rotulo + "] falhou, esperado: [" + esperado + "] e gerado: [" + gerado +"]", esperado, gerado);
		}
	}

}
