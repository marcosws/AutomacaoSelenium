package com.github.marcosws.context;

public class ContextApp {
	
	private static String appPath = System.getProperty("user.dir");
	private static String defaultPartialPath = "/src/test/resources/applications/";
	private static String typeProtocol = "file:///";
	
	public static final String ADDRESS_CADASTRO_UNICO = typeProtocol + appPath + defaultPartialPath + "prototipo-cadastro-unico.html";
	public static final String ADDRESS_FORMULARIO_IFRAME = typeProtocol +  appPath + defaultPartialPath + "prototipo-formulario-iframe.html"; 
	public static final String ADDRESS_CAMPO_TREINAMENTO = typeProtocol +  appPath + defaultPartialPath + "prototipo-campo-treinamento.html";
	public static final String ADDRESS_TECLADO_VIRTUAL =  typeProtocol + appPath + defaultPartialPath + "prototipo-teclado-virtual"; 
	
}
