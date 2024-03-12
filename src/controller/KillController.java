package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}

	private String os() {
		return System.getProperty("os.name");
	}

	public void processList() throws IOException {

		boolean isWindows = os().contains("Windows");
		BufferedReader bReader;
		if (isWindows)
			bReader = execCommand("TASKLIST /FO TABLE");
		else
			bReader = execCommand("ps -ef");

		String line = bReader.readLine();
		while (line != null) {
			System.out.println(line);
			line = bReader.readLine();
		}

		bReader.close();
	}

	public String killPid(int pid) throws IOException {
		boolean isWindows = os().contains("Windows");
		BufferedReader bReader;
		if (isWindows)
			bReader = execCommand("TASKKILL /PID " + pid);
		else
			bReader = execCommand("kill -9 " + pid);
		
		return bReader.readLine();
	}
	
	public String killName(String name) throws IOException {
		boolean isWindows = os().contains("Windows");
		BufferedReader bReader;
		if(isWindows)
			bReader = execCommand("TASKKILL /IM " + name);
		else
			bReader = execCommand("pkill -f " + name);
		
		return bReader.readLine();
	}

	private BufferedReader execCommand(String command) throws IOException {
		return new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(command).getInputStream()));
	}

}
