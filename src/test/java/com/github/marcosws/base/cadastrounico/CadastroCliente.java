package com.github.marcosws.base.cadastrounico;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.github.marcosws.utils.Common;

public class CadastroCliente {
	
	private String tipoDeCadastro;
	private String nome;
	private String cpf;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String telefone;
	private String celular;
	private String email;
	private boolean clienteAutorizaIPEmail;
	
	private boolean cadastrar;
	private boolean limpar;
	private boolean validaMensagem;
	private String textoMensagem;
	
	private String statusNome;
	private String statusCpf;
	private String statusNomeFantasia;
	private String statusRazaoSocial;
	private String statusCnpj;
	private String statusTelefone;
	private String statusCelular;
	private String statusEmail;
	
public void carregaMassa(String nomeClasseArquivoJson){
		
		Common common = new Common();
		String baseDir = System.getProperty("user.dir");
		String partialDir = "//src//test//resources//data//cadastrounico//{nomeClass}.json";
		String json = common.readFile(baseDir.concat(partialDir.replace("{nomeClass}", nomeClasseArquivoJson)));
		
		try{
			
			Object obj = JSONValue.parse(json);  
		    JSONObject jsonObject = (JSONObject) obj; 
		    
			this.setTipoDeCadastro(jsonObject.get("tipoDeCadastro").toString());
			this.setNome(jsonObject.get("nome").toString());
			this.setCpf(jsonObject.get("cpf").toString());
			this.setNomeFantasia(jsonObject.get("nomeFantasia").toString());
			this.setRazaoSocial(jsonObject.get("razaoSocial").toString());
			this.setCnpj(jsonObject.get("cnpj").toString());
			this.setTelefone(jsonObject.get("telefone").toString());
			this.setCelular(jsonObject.get("celular").toString());
			this.setEmail(jsonObject.get("email").toString());
			this.setClienteAutorizaIPEmail((boolean) jsonObject.get("clienteAutorizaIPEmail"));
			this.setCadastrar((boolean) jsonObject.get("cadastrar"));
			this.setLimpar((boolean) jsonObject.get("limpar"));
			this.setValidaMensagem((boolean) jsonObject.get("validaMensagem"));
			this.setTextoMensagem(jsonObject.get("textoMensagem").toString());
			this.setStatusNome(jsonObject.get("statusNome").toString());
			this.setStatusCpf(jsonObject.get("statusCpf").toString());
			this.setStatusNomeFantasia(jsonObject.get("statusNomeFantasia").toString());
			this.setStatusRazaoSocial(jsonObject.get("statusRazaoSocial").toString());
			this.setStatusCnpj(jsonObject.get("statusCnpj").toString());
			this.setStatusTelefone(jsonObject.get("statusTelefone").toString());
			this.setStatusCelular(jsonObject.get("statusCelular").toString());
			this.setStatusEmail(jsonObject.get("statusEmail").toString());
			
			//System.out.println(System.getProperty("file.encoding"));
		}
		catch(NullPointerException e){
			
			//LogTest logTest = new LogTest();
			//logTest.LogFail("Erro no layout do arquivo Json: " + nomeClasseArquivoJson);
			
		}
		
	}

	public String getTipoDeCadastro() {
		return tipoDeCadastro;
	}
	
	public void setTipoDeCadastro(String tipoDeCadastro) {
		this.tipoDeCadastro = tipoDeCadastro;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getEmail() {
		return email;
	}
	
	public boolean isClienteAutorizaIPEmail() {
		return clienteAutorizaIPEmail;
	}

	public void setClienteAutorizaIPEmail(boolean clienteAutorizaIPEmail) {
		this.clienteAutorizaIPEmail = clienteAutorizaIPEmail;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isCadastrar() {
		return cadastrar;
	}
	
	public void setCadastrar(boolean cadastrar) {
		this.cadastrar = cadastrar;
	}
	
	public boolean isLimpar() {
		return limpar;
	}
	
	public void setLimpar(boolean limpar) {
		this.limpar = limpar;
	}
	
	public String getStatusNome() {
		return statusNome;
	}
	
	public void setStatusNome(String statusNome) {
		this.statusNome = statusNome;
	}
	
	public String getStatusCpf() {
		return statusCpf;
	}
	
	public void setStatusCpf(String statusCpf) {
		this.statusCpf = statusCpf;
	}
	
	public String getStatusNomeFantasia() {
		return statusNomeFantasia;
	}
	
	public void setStatusNomeFantasia(String statusNomeFantasia) {
		this.statusNomeFantasia = statusNomeFantasia;
	}
	
	public String getStatusRazaoSocial() {
		return statusRazaoSocial;
	}
	
	public void setStatusRazaoSocial(String statusRazaoSocial) {
		this.statusRazaoSocial = statusRazaoSocial;
	}
	
	public String getStatusCnpj() {
		return statusCnpj;
	}
	
	public void setStatusCnpj(String statusCnpj) {
		this.statusCnpj = statusCnpj;
	}
	
	public String getStatusTelefone() {
		return statusTelefone;
	}
	
	public void setStatusTelefone(String statusTelefone) {
		this.statusTelefone = statusTelefone;
	}
	
	public String getStatusCelular() {
		return statusCelular;
	}
	
	public void setStatusCelular(String statusCelular) {
		this.statusCelular = statusCelular;
	}
	
	public String getStatusEmail() {
		return statusEmail;
	}
	
	public void setStatusEmail(String statusEmail) {
		this.statusEmail = statusEmail;
	}

	public String getTextoMensagem() {
		return textoMensagem;
	}

	public void setTextoMensagem(String textoMensagem) {
		this.textoMensagem = textoMensagem;
	}

	public boolean isValidaMensagem() {
		return validaMensagem;
	}

	public void setValidaMensagem(boolean validaMensagem) {
		this.validaMensagem = validaMensagem;
	}
	
	
	
}
