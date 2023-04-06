/**
 * 
 */
package middleware;

import org.apache.axis2.AxisFault;
import java.util.Arrays;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * @author alexandra
 *
 */
@SuppressWarnings("unused")
public class MiddleService extends AddonsService {
	public MiddleService() {
		super("Kernel");
	}	
	public String[] invoke(String serviceStr, String function, String[] paramNames, String[] param, String token) {

		message("This is " + serviceStr);
		String str = "<<" + serviceStr + "<<" + function + "(";
		for (int i = 0; i < param.length; i++)
			if (param[i].length() < 50)
				str += "," + param[i];
		str = str + "," + token + ")";
		registerOperationCall(str);
		message(str);
		ArrayList<String> result = new ArrayList<String>();
		try {
			String link = "http://127.0.0.1:8080/";
			String nameSpace = "";
			// ::::::::::::::::::::::::
			String[] ends = new String[2];
			ends[0] ="RemoteShellService|http://remote|http://127.0.0.1:8080/RemoteShell/services";
			ends[1] ="TextFileContentRetriever|http://axis2server.services.com|http://127.0.0.1:8080/TextFileServicesServer/services/";

			for (int i = 0; i < ends.length; i++) {
				String[] par = ends[i].split("\\|");

				if (par[0].equals(serviceStr)) {
					nameSpace = par[1];
					link = par[2];
					message(" Calling from " + par[0]);
				} else {
					message("Exception--> Caling from localhost");
				}
			}	
			// :::::::::::::::
			GenericWebServiceStub service = new GenericWebServiceStub(link,serviceStr, nameSpace);
			service.setMethod(function);
			service.addParam(paramNames, param);
			service.addParam("token", token);
			try {
				service.send();
			} catch (Exception e) {
				error(e.toString());
			}
			while (service.hasNext()) {
				result.add(service.getNext());
			}
			service.close();
		} catch (Exception e) {
			error("This is Kernel run() for TTT SQL exception:" +serviceStr + ":" + function + e);
			e.printStackTrace();
		}
		String[] ar = new String[result.size()];
		return result.toArray(ar);
	}
}