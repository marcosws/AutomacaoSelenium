package com.github.marcosws.base.campotreinamento;

import org.w3c.dom.Document;

import com.github.marcosws.utils.Common;

public class Geral {
	
	private String estado;
	private String nivel;
	private String percentual1;
	private String percentual2;
	private String alert;
	private String mensagemAlert;
	private String confirm;
	private String aceitaConfirm;
	private String mensagemConfirm;
	private String prompt;
	private String aceitaPrompt;
	private String mensagemPrompt;
	private String textoPrompt;
	
	public void carregaMassa(String nomeClasseArquivoXml){
		
		Common common = new Common();
		String baseDir = System.getProperty("user.dir");
		String partialDir = "//src//test//resources//data//campotreinamento//{nomeClass}.xml";
		Document document = common.readXML(baseDir.concat(partialDir.replace("{nomeClass}", nomeClasseArquivoXml)));
		
		this.setEstado(document.getDocumentElement().getElementsByTagName("estado").item(0).getTextContent());
		this.setNivel(document.getDocumentElement().getElementsByTagName("nivel").item(0).getTextContent());
		this.setPercentual1(document.getDocumentElement().getElementsByTagName("percentual1").item(0).getTextContent());
		this.setPercentual2(document.getDocumentElement().getElementsByTagName("percentual2").item(0).getTextContent());
		this.setAlert(document.getDocumentElement().getElementsByTagName("alert").item(0).getTextContent());
		this.setMensagemAlert(document.getDocumentElement().getElementsByTagName("mensagemAlert").item(0).getTextContent());
		this.setConfirm(document.getDocumentElement().getElementsByTagName("confirm").item(0).getTextContent());
		this.setAceitaConfirm(document.getDocumentElement().getElementsByTagName("aceitaConfirm").item(0).getTextContent());
		this.setMensagemConfirm(document.getDocumentElement().getElementsByTagName("mensagemConfirm").item(0).getTextContent());
		this.setPrompt(document.getDocumentElement().getElementsByTagName("prompt").item(0).getTextContent());
		this.setAceitaPrompt(document.getDocumentElement().getElementsByTagName("aceitaPrompt").item(0).getTextContent());
		this.setMensagemPrompt(document.getDocumentElement().getElementsByTagName("mensagemPrompt").item(0).getTextContent());
		this.setTextoPrompt(document.getDocumentElement().getElementsByTagName("textoPrompt").item(0).getTextContent());
		
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getPercentual1() {
		return percentual1;
	}
	public void setPercentual1(String percentual1) {
		this.percentual1 = percentual1;
	}
	public String getPercentual2() {
		return percentual2;
	}
	public void setPercentual2(String percentual2) {
		this.percentual2 = percentual2;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	public String getMensagemAlert() {
		return mensagemAlert;
	}
	public void setMensagemAlert(String mensagemAlert) {
		this.mensagemAlert = mensagemAlert;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getAceitaConfirm() {
		return aceitaConfirm;
	}
	public void setAceitaConfirm(String aceitaConfirm) {
		this.aceitaConfirm = aceitaConfirm;
	}
	public String getMensagemConfirm() {
		return mensagemConfirm;
	}
	public void setMensagemConfirm(String mensagemConfirm) {
		this.mensagemConfirm = mensagemConfirm;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public String getAceitaPrompt() {
		return aceitaPrompt;
	}
	public void setAceitaPrompt(String aceitaPrompt) {
		this.aceitaPrompt = aceitaPrompt;
	}
	public String getMensagemPrompt() {
		return mensagemPrompt;
	}
	public void setMensagemPrompt(String mensagemPrompt) {
		this.mensagemPrompt = mensagemPrompt;
	}
	public String getTextoPrompt() {
		return textoPrompt;
	}
	public void setTextoPrompt(String textoPrompt) {
		this.textoPrompt = textoPrompt;
	}
	
}
