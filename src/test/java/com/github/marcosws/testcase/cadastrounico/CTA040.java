package com.github.marcosws.testcase.cadastrounico;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.marcosws.context.cadastrounico.CadastroUnico;
import com.github.marcosws.nav.cadastrounico.CadastroClienteNav;
import com.github.marcosws.nav.cadastrounico.ParametrosCadastroNav;

import reglog.logs.execution.Log;

public class CTA040 {
	
	/*
	 * CTA040 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar label informativa 
	 * e omitindo o preenchimento do campo Nome Fantasia e preenchendo demais campos com dados válidos.
	 */
	
	@Test
	public void runTestCase() {
		ParametrosCadastroNav parametrosCadastroNav = new ParametrosCadastroNav();
		CadastroClienteNav cadastroClienteNav = new CadastroClienteNav();
		parametrosCadastroNav.executaParametrosCadastro(this.getClass().getSimpleName());
		cadastroClienteNav.executaCadastroCliente(this.getClass().getSimpleName());
	}

	@Before
	public void startApplication() {
		
		Log.title("CTA040 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar label informativa" + 
				" e omitindo o preenchimento do campo Nome Fantasia e preenchendo demais campos com dados válidos.");
		
		CadastroUnico cadastroUnico = new CadastroUnico();
		cadastroUnico.iniciarCadastroUnico();
	}

	@After
	public void endApplication() {
		CadastroUnico cadastroUnico = new CadastroUnico();
		cadastroUnico.finalizarCadastroUnico();
	}

}
