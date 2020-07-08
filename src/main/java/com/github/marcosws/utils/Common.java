package com.github.marcosws.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Common {
	
	public void sleep(long miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public String readFile(String filePath) {
		
		String line;
        String fileContent = "";
        String returnContent = "";
        BufferedReader in = null;

        try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        
		while(true)
		{
			try {
				line = in.readLine();
				if(line == null)
					break;
				fileContent += line;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte ptext[] = fileContent.getBytes();
		try {
			returnContent = new String(ptext, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return returnContent;
		
	}
	public String removeMask(String field) {
		
		field = field.replace(".", "");
		field = field.replace("-", "");
		field = field.replace("/", "");
		field = field.replace("(", "");
		field = field.replace(")", "");
		return field;
		
	}

}
