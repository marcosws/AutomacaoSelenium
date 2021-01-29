package com.github.marcosws.core;

import org.junit.Assert;

import reglog.logs.execution.Log;

public class LogTest {
	
	public void LogInfo(String msg){
		Log.info(msg);
	}
	
	public void LogAssert(String msg, String expected, String actual){
		
		String assertionError = null;
	    try {
	    	Assert.assertEquals(msg, expected, actual);
	    	Log.pass(msg);
	    }
	    catch (AssertionError ae) {
	        assertionError = ae.toString();
	        Log.fail(msg);
	        System.out.println(assertionError);
	    }
	    
	}

	public void LogFail(String msg){
		Log.fail(msg);
		Assert.fail(msg);
	}
	
	public void LogPass(String msg) {
		Log.pass(msg);
		Assert.assertTrue(msg, true);
	}

}
