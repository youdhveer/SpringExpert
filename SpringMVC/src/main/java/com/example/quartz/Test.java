package com.example.quartz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {

	public static void main(String ...args){
		
		FileInputStream in;
		try {
			in = new FileInputStream("src/main/resources/test.properties");
			Properties props = new Properties();
			props.load(in);
			System.out.println(props.getProperty("test.country"));
			in.close();

			FileOutputStream out = new FileOutputStream("src/main/resources/test.properties");
			props.setProperty("test.country", "India");
			props.store(out, null);
			out.close();
			System.out.println(props.getProperty("test.country"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
