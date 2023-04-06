package com.services.axis2server;

import java.rmi. RemoteException;
import org.apache.axis2.AxisFault;
import com.services.axis2server.TextFileContentRetrieverStub.*;

public class TextFileContentRetrieverClient {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			TextFileContentRetrieverStub stub = new TextFileContentRetrieverStub();
			
			Test test = new Test();
			TestResponse res1 = stub.test(test);
			System.out.println("Testing a simple invocation: \n" + res1.get_return());
			
			RetrieveTextFileContent retrieveFile = new RetrieveTextFileContent();
			String fileName = "C:\\Users\\maria\\my_text_file.txt";
			retrieveFile.setPath(fileName);
			RetrieveTextFileContentResponse res2 = stub.retrieveTextFileContent(retrieveFile);
			System.out.println("\n Retriving the " + fileName + " file content: \n" + res2.get_return());
		}catch(AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
}

