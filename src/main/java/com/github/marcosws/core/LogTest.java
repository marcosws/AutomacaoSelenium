package com.github.marcosws.core;

import org.junit.Assert;

public class LogTest {
	
	public void LogInfo(String msg){
		System.out.println(msg);
	}
	public void LogPass(String msg){
		System.out.println(msg);
	}
	public void LogFail(String msg){
		System.out.println(msg);
		Assert.fail(msg);
	}

}
