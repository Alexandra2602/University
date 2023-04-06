package com.services.axis2server;

import java.util.ArrayList;
import java.util.Collections;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMFactory;
import org.apache.axis2.client.Options;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.ServiceClient;
import java.util.Iterator;
import org.apache.axis2.AxisFault;
import org.apache.axiom.soap.SOAP12Constants;
import org.apache.axiom.om.OMText;

public class GenericWebServiceStub {
	private String path;
	private ArrayList<OMElement> params;
	private ArrayList<String> paramNames;
	private OMFactory factory;
	private OMNamespace omNs;
	private String serviceName;
	private String method;
	private Iterator<?> iter;
	private ServiceClient service;
	
	public GenericWebServiceStub(String _path, String _serviceName, String nameSpace) {
		path = _path;
		params = new ArrayList<OMElement>();
		paramNames = new ArrayList<String>();
		serviceName = _serviceName;
		factory = OMAbstractFactory.getOMFactory();
		omNs = factory.createOMNamespace(nameSpace, serviceName);
	}
	public void setMethod(String _method) {
		method = _method;
		params.clear();
		paramNames.clear();
	}
	
	// code to send
	public void sendBinary() throws AxisFault {
		Options options = new Options();
		options.setAction(method);
		
		options.setTo(new EndpointReference(path + "/" + serviceName));
		options.setProperty(Constants.Configuration.ENABLE_MTOM, Constants.VALUE_TRUE);
		options.setSoapVersionURI(SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);
			service = new ServiceClient();
			service.setOptions(options);
			OMElement methodE = factory.createOMElement(method, omNs);
	
			for (int i = 0; i < params.size(); i++) {
				methodE.addChild(params.get(i));
			}
			OMElement rawResult = service.sendReceive(methodE);
			iter = rawResult.getChildren();
	}
	
	public void send() throws AxisFault {
		Options options = new Options();
		options.setTo(new EndpointReference(path + "/" + serviceName));
		options.setAction(method);
		service = new ServiceClient();
		service.setOptions(options);
		OMElement methodE = factory.createOMElement(method, omNs);
		for (int i = 0; i < params.size(); i++) {
			methodE.addChild(params.get(i));
		}
		OMElement rawResult = service.sendReceive(methodE);
		iter = rawResult.getChildren();
	}
	
	public boolean hasNext() {
		return iter.hasNext();
	}
	
	public String getNext() {
		return ((OMElement) iter.next()).getText();
	}
	
	public String getNextBinary() {
		return ((OMText) ((OMElement)
				iter.next()).getFirstElement().getFirstOMChild()).getText();
	}
	
	public void close() throws AxisFault {
	
		service.cleanupTransport();
	}
	
	// code to add params
	public void addParam(String name, String paramIn) {
		paramNames.add(name);
		OMElement p = factory.createOMElement(name, omNs);
		p.setText(paramIn);
		params.add(p);
	}
	
	public void addParam(String name, int paramIn) {
		addParam(name, "" + paramIn);
	}
	
	public void addParam(String name, double paramIn) {
		addParam(name, "" + paramIn);
	}
	
	public void addParam(String name, boolean paramIn) {
		addParam(name, "" + paramIn);
	}
	
		public void addParam(String name, float paramIn) {
	addParam(name, "" + paramIn);
	}
			
	public void addParam(String name, long paramIn) {
		addParam(name, "" + paramIn);
	}
	
	public void addParam(String [] names, Object[] paramIn) throws UnsupportedOperationException {
		OMElement p;
		Collections.addAll(paramNames, names);
		for (int i = 0; i < paramIn.length; i++) {
			// is it a type we know
			Object o = paramIn[i];
			Class<? extends Object> c = o.getClass();
			if (c == String.class) {
				// check for any arrays in param
				if (((String) o).length() >= 7 && ((String) o).substring(0, 7).equals("||ARR||")) {
					// an array
					String str = ((String) o).substring(7);
					StringBuilder strB = new StringBuilder();
					for (int x = 0; x < str.length(); x++) {
						if (str.charAt(x) == '|') {
							OMElement p1 = factory.createOMElement(paramNames.get(i), omNs);
							params.add(p1);
							p1.setText(strB.toString());
							strB = new StringBuilder();
						} else {
							strB.append(str.charAt(x));
						}
					}
					OMElement p1 = factory.createOMElement(paramNames.get(i), omNs);
					params.add(p1);
					p1.setText(strB.toString());
				} else {
					if (!paramIn[i].equals("")) {
						p = factory.createOMElement(paramNames.get(i), omNs);
						p.setText((String) paramIn[i]);
						params.add(p);
					}
				}
			} else {
				throw new UnsupportedOperationException("Unsupported Type:" + o.getClass());
			}
		}
	}
	
	 public void addParam(String name, Object[] paramIn) throws UnsupportedOperationException
	 {
		 String[] names = new String[paramIn.length];
		 for (int i = 0;i<paramIn.length;i++) names[i] = name;
	
		 addParam(names, paramIn);
	}
	
}
