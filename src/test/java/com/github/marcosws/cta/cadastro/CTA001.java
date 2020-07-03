package com.github.marcosws.cta.cadastro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.marcosws.nav.cadastro.CadastroNav;
import com.github.marcosws.utils.Common;

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
		Common common = new Common();
		common.sleep(5000);
		
		CadastroNav cadastroNav = new CadastroNav();
		cadastroNav.finalizarCadastro();
	}

}
