package com.github.marcosws.base.campotreinamento;

import org.w3c.dom.Document;
import com.github.marcosws.utils.Common;


public class CadastroBasico {
	
	private String nome;
	private String endereco;
	private String numero;
	private String cep;
	
	private String profissao;
	private String carro;
	private String moto;
	private String utilitario;
	private String montadora;
	
	
	public void carregaMassa(String nomeClasseArquivoXml){
			
			Common common = new Common();
			String baseDir = System.getProperty("user.dir");
			String partialDir = "//src//test//resources//data//campotreinamento//{nomeClass}.xml";
			Document document = common.readXML(baseDir.concat(partialDir.replace("{nomeClass}", nomeClasseArquivoXml)));

			this.setNome(document.getDocumentElement().getElementsByTagName("nome").item(0).getTextContent());
			this.setEndereco(document.getDocumentElement().getElementsByTagName("endereco").item(0).getTextContent());
			this.setNumero(document.getDocumentElement().getElementsByTagName("numero").item(0).getTextContent());
			this.setCep(document.getDocumentElement().getElementsByTagName("cep").item(0).getTextContent());
			this.setProfissao(document.getDocumentElement().getElementsByTagName("profissao").item(0).getTextContent());
			this.setCarro(document.getDocumentElement().getElementsByTagName("carro").item(0).getTextContent());
			this.setMoto(document.getDocumentElement().getElementsByTagName("moto").item(0).getTextContent());
			this.setUtilitario(document.getDocumentElement().getElementsByTagName("utilitario").item(0).getTextContent());
			this.setMontadora(document.getDocumentElement().getElementsByTagName("montadora").item(0).getTextContent());
				
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getProfissao() {
		return profissao;
	}


	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}


	public String getCarro() {
		return carro;
	}


	public void setCarro(String carro) {
		this.carro = carro;
	}


	public String getMoto() {
		return moto;
	}


	public void setMoto(String moto) {
		this.moto = moto;
	}


	public String getUtilitario() {
		return utilitario;
	}


	public void setUtilitario(String utilitario) {
		this.utilitario = utilitario;
	}


	public String getMontadora() {
		return montadora;
	}


	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}

}
