package com.github.marcosws.testcase.campotreinamento;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.marcosws.context.campotreinamento.CampoTreinamento;
import com.github.marcosws.nav.campotreinamento.CadastroBasicoNav;
import com.github.marcosws.nav.campotreinamento.ConsultaNav;
import com.github.marcosws.nav.campotreinamento.EmpresasNav;
import com.github.marcosws.nav.campotreinamento.GeralNav;
import com.github.marcosws.utils.Common;

import reglog.logs.execution.Log;

public class CTA001 {
	
	@Test
	public void runTestCase() {
		
		Log.title("CTA001 - Campo de Treinamento");
		
		CadastroBasicoNav cadastroBasicoNav = new CadastroBasicoNav();
		cadastroBasicoNav.executaCadastroBasico(this.getClass().getSimpleName());
		
		GeralNav geralNav = new GeralNav();
		geralNav.executaGeral(this.getClass().getSimpleName());
		
		EmpresasNav empresasNav = new EmpresasNav();
		empresasNav.executaEmpresas(this.getClass().getSimpleName());
		
		ConsultaNav consultaNav = new ConsultaNav();
		consultaNav.executaConsulta(this.getClass().getSimpleName());
	}

	@Before
	public void startApplication() {
		Log.info("Iniciando aplicação");
		CampoTreinamento campoTreinamento = new CampoTreinamento();
		campoTreinamento.iniciarCampoTreinamento();
	}

	@After
	public void endApplication() {
		Log.info("Finalizando a Aplicação aplicação");
		Common common = new Common();
		common.sleep(12000);
		
		CampoTreinamento campoTreinamento = new CampoTreinamento();
		campoTreinamento.finalizarCampoTreinamento();
	}

}
