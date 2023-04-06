/**
 * 
 */
package middleware;

import java.sql.Connection;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.Context;
import java.util.LinkedList;
import java.util.Properties;
import java.io.*;
import java.sql.*;
import java.sql.DriverManager;

/**
 * @author alexandra
 *
 */

@SuppressWarnings("unused")
class FixedSizeQueue<E> extends LinkedList<E> {
	private static final long serialVersionUID = 1L;
	private int capacity = 10;
	
	public FixedSizeQueue(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public boolean add(E e) {
		if (size() >= capacity)
			removeFirst();
		return super.add(e);
	}
}

public class AddonsService {
	protected String serviceName;
	protected Connection connection;
	protected String operationsFile = "./history.txt";
	
	// public String
	public AddonsService(String _service) {
		serviceName = _service;
		// dbConnection();
	}
	
	protected void close() {
		try {
			connection.close();
		} catch (Exception e) {
			error("Error Closing Database Connection");
		}
	}
	
	protected synchronized boolean registerOperationCall(String call) {
		try {
			File opFile = new File(operationsFile);
			if (!opFile.exists())
				opFile.createNewFile();
			FileWriter fw = new FileWriter(opFile, true); // the true will append the new data
			fw.write(call + System.lineSeparator());// appends the string to the file
			fw.close();
			return true;
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
			return false;
		}
	}
	
	public synchronized void clearOperationHistory() {
		try {
			File opFile = new File(operationsFile);
			if (!opFile.exists())
				opFile.createNewFile();
			PrintWriter writer = new PrintWriter(operationsFile);
			writer.print("");
			writer.close();
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}
	
	public String[] lastCalls(int n) {
		try {
			// Open the file
			FileInputStream fstream = new FileInputStream(operationsFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			// Read File Line By Line
			FixedSizeQueue<String> res = new FixedSizeQueue<String>(n);
			while ((strLine = br.readLine()) != null) {
				// Add the content to the fixed size result
				res.add(strLine);
			}
			// Close the input stream
			br.close();
			String[] ret = res.toArray(new String[res.size()]);
			return ret;
	} catch (IOException ioe) {
		System.err.println("IOException: " + ioe.getMessage());
		return new String[] {};
	}
}
	
	protected void error(String error) {
		System.out.println("[" + serviceName + "-Error]" + error);
	}
	protected void message(String message) {
		System.out.println("[" + serviceName + "-Message]" + message);
	}
}

