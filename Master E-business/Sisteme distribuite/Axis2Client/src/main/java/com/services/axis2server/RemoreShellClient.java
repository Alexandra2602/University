/**
 * 
 */
package com.services.axis2server;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author alexandra
 *
 */
public class RemoreShellClient {

	public static final String EXIT_COMMAND = "exit";
	public static final String PROMPTER = "RemoteShellWS> ";
	
	public static void main(String[] args) {
		String nameSpace = "http://remote";
		String function = "executeCommand";
		String paramName = "command";
		String inputCommand = "";
		String serviceStr = "RemoteShellService";
		ArrayList<String> results = new ArrayList<String>();
		// TODO Auto-generated method stub
		GenericWebServiceStub stub = new GenericWebServiceStub("http://localhost:8080/RemoteShell/services",serviceStr);
	
		while (!inputCommand.trim().equalsIgnoreCase(EXIT_COMMAND))
		{
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.print(PROMPTER);
			inputCommand = input.nextLine();
			try {
				stub.setMethod(function);
				stub.addParam(paramName, inputCommand);
				try {
					stub.send();
				} catch (Exception e) {
					System.err.println(e.getStackTrace());
				}
				while (stub.hasNext()) {
					results.add(stub.getNext());
				}
				stub.close();
			} catch (Exception e) {
				System.err.println("This is exception:" + serviceStr +":" + function + e);
				e.printStackTrace();
			}
			for(String res : results)
				System.out.print(res);
			results.clear();
		}
		System.out.println("Closing the remote shell service client ...");
	}
}
