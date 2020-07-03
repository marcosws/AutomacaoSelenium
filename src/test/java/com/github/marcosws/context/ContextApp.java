package com.github.marcosws.context;

public class ContextApp {
	
	private static String appPath = System.getProperty("user.dir");
	private static String defaultPartialPath = "/src/test/resources/applications/";
	public static final String ADDRESS_PROTO_CAD = appPath + defaultPartialPath + "prototipo_cadastro.html";
	public static final String ADDRESS_PROTO_IFRAME = appPath + defaultPartialPath + "prototipo-iframe.html";
	public static final String ADDRESS_PROTO_INDEX = appPath + defaultPartialPath + "prototipo-index.html";
	public static final String ADDRESS_PROTO_LOGIN = appPath + defaultPartialPath + "prototipo-login.html";

}
