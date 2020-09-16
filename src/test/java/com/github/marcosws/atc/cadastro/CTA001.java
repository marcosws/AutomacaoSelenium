package com.github.marcosws.atc.cadastro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.marcosws.nav.cadastro.CadastroNav;

public class CTA001{

	@Test
	public void runTestCase() {
		CadastroNav cadastroNav = new CadastroNav();
		cadastroNav.executaCadastro(this.getClass().getSimpleName());
	}

	@Before
	public void startApplication() {
		CadastroNav cadastroNav = new CadastroNav();
		cadastroNav.iniciarCadastro();
	}

	@After
	public void endApplication() {
		CadastroNav cadastroNav = new CadastroNav();
		cadastroNav.finalizarCadastro();
	}

}
