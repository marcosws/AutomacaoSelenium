package com.github.marcosws.testcase.campotreinamento;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.marcosws.context.campotreinamento.CampoTreinamento;
import com.github.marcosws.utils.Common;

public class CTA001 {
	
	@Test
	public void runTestCase() {

	}

	@Before
	public void startApplication() {
		CampoTreinamento campoTreinamento = new CampoTreinamento();
		campoTreinamento.iniciarCampoTreinamento();
	}

	@After
	public void endApplication() {
		
		Common common = new Common();
		common.sleep(5000);
		
		CampoTreinamento campoTreinamento = new CampoTreinamento();
		campoTreinamento.finalizarCampoTreinamento();
	}

}
