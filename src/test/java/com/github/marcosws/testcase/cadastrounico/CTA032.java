package com.github.marcosws.testcase.cadastrounico;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.marcosws.context.cadastrounico.CadastroUnico;
import com.github.marcosws.nav.cadastrounico.CadastroClienteNav;

import reglog.logs.execution.Log;

public class CTA032 {
	
	/*
	 * CTA032 - Realizar o cadastro de cliente para pessoa jurídica sem parametrização (Apresentar caixa de dialogo) 
	 * omitindo o preenchimento do campo Razão Social e preenchendo demais campos com dados válidos.
	 */
	
	@Test
	public void runTestCase() {
		CadastroClienteNav cadastroClienteNav = new CadastroClienteNav();
		cadastroClienteNav.executaCadastroCliente(this.getClass().getSimpleName());
	}

	@Before
	public void startApplication() {
		
		Log.title("CTA032 - Realizar o cadastro de cliente para pessoa jurídica sem parametrização (Apresentar caixa de dialogo)" + 
				" omitindo o preenchimento do campo Razão Social e preenchendo demais campos com dados válidos.");
		
		CadastroUnico cadastroUnico = new CadastroUnico();
		cadastroUnico.iniciarCadastroUnico();
	}

	@After
	public void endApplication() {
		CadastroUnico cadastroUnico = new CadastroUnico();
		cadastroUnico.finalizarCadastroUnico();
	}

}
