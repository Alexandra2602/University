package com.services.axis2server;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis2.AxisFault;

import com.services.axis2server.TextFileContentRetrieverStub.RetrieveTextFileContent;
import com.services.axis2server.TextFileContentRetrieverStub.RetrieveTextFileContentResponse;

/**
 * Servlet implementation class WSClient
 */
public class WSClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WSClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fContent="";
		try {
			TextFileContentRetrieverStub stub= new TextFileContentRetrieverStub();
			
			RetrieveTextFileContent retrieveFile= new RetrieveTextFileContent();
			retrieveFile.setPath(request.getParameter("fname"));
			RetrieveTextFileContentResponse res2= stub.retrieveTextFileContent(retrieveFile);
			fContent=res2.get_return();
			request.setAttribute("fname", request.getParameter("fname"));
		}catch(AxisFault e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}catch(RemoteException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/axis2client/wsclient.jsp?fcontent="+fContent).forward(request, response);
	}

}
