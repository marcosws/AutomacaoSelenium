package com.github.marcosws.base.cadastrounico;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.github.marcosws.core.Validation;
import com.github.marcosws.utils.Common;

public class ParametrosCadastro {
	
	private String mensagemDeInconsistencia;
	private boolean apresentarMensagemDeconfirmacaoDeCadastro;
	private boolean apresentarMensagemDeconfirmacaoAntesDeLimparOsCampos;
	
	public void carregaMassa(String nomeClasseArquivoJson){
		
		Common common = new Common();
		String baseDir = System.getProperty("user.dir");
		String partialDir = "//src//test//resources//data//cadastrounico//{nomeClass}.json";
		String json = common.readFile(baseDir.concat(partialDir.replace("{nomeClass}", nomeClasseArquivoJson)));
		
		try{
			
			Object obj = JSONValue.parse(json);  
		    JSONObject jsonObject = (JSONObject) obj; 
		    
			this.setMensagemDeInconsistencia(jsonObject.get("mensagemDeInconsistencia").toString());
			this.setApresentarMensagemDeconfirmacaoDeCadastro((boolean) jsonObject.get("apresentarMensagemDeconfirmacaoDeCadastro"));
			this.setApresentarMensagemDeconfirmacaoAntesDeLimparOsCampos((boolean) jsonObject.get("apresentarMensagemDeconfirmacaoAntesDeLimparOsCampos"));
			
		}
		catch(NullPointerException e){
			
			//e.printStackTrace();
			Validation validacao = new Validation();
			validacao.falha("Erro no layout do arquivo Json: " + nomeClasseArquivoJson + ".json, verifique os campos no json e na classe ParametrosCadastro");
			
		}
			
	}
	
	public String getMensagemDeInconsistencia() {
		return mensagemDeInconsistencia;
	}
	public void setMensagemDeInconsistencia(String mensagemDeInconsistencia) {
		this.mensagemDeInconsistencia = mensagemDeInconsistencia;
	}
	public boolean isApresentarMensagemDeconfirmacaoDeCadastro() {
		return apresentarMensagemDeconfirmacaoDeCadastro;
	}
	public void setApresentarMensagemDeconfirmacaoDeCadastro(boolean apresentarMensagemDeconfirmacaoDeCadastro) {
		this.apresentarMensagemDeconfirmacaoDeCadastro = apresentarMensagemDeconfirmacaoDeCadastro;
	}
	public boolean isApresentarMensagemDeconfirmacaoAntesDeLimparOsCampos() {
		return apresentarMensagemDeconfirmacaoAntesDeLimparOsCampos;
	}
	public void setApresentarMensagemDeconfirmacaoAntesDeLimparOsCampos(boolean apresentarMensagemDeconfirmacaoAntesDeLimparOsCampos) {
		this.apresentarMensagemDeconfirmacaoAntesDeLimparOsCampos = apresentarMensagemDeconfirmacaoAntesDeLimparOsCampos;
	}
	

}
