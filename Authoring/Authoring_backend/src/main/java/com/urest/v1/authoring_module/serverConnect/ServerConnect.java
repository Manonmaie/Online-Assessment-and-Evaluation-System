package com.urest.v1.authoring_module.serverConnect;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ServerConnect {
	public static Status execCurlPushCommand(String path){
		String url = "https://file.io";
		String file = "file=@"+path;
		
		ObjectMapper mapper = new ObjectMapper();
		
		String[] command = { "curl", "-F", file, url };
		ProcessBuilder process = new ProcessBuilder(command);
		//process.redirectErrorStream(true);
		Process p;
		try {
			p = process.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}
			String result = builder.toString();
			Status res = new Status(result);
			return res;
		} catch (IOException e) {
			System.out.print("error");
			e.printStackTrace();
		}	
		return null;	
	}
	
	public static void execCurlPullCommand(String path, String key){
		String url = "https://file.io/"+key;
		String file = path;
		
		String[] command = { "curl", url};
		ProcessBuilder process = new ProcessBuilder(command);
		//process.redirectErrorStream(true);
		Process p;
		try {
			PrintStream out = new PrintStream(new FileOutputStream(file));
			System.setOut(out);
			p = process.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}
			String result = builder.toString();
			System.out.print(result);
			
		} catch (IOException e) {
			System.out.print("error");
			e.printStackTrace();
		}		
	}
}

