package com.june.apps.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@RestController
@RequestMapping("/")
public class CallWS {
	public static final String rBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:us=\"http://june.com/customerwsdlmodel\">" +
			"<soapenv:Header/>" + 
			"<soapenv:Body>" + 
			"<us:getUserRequest>" + 
			"<us:name>NinaPark</us:name>" + 
			"</us:getUserRequest>" + 
			"</soapenv:Body>" + 
			"</soapenv:Envelope>";

	@Autowired
	private WebClient.Builder webClientBuilder;

	@GetMapping("/getWs")
	public ResponseEntity<String> getUserWithRest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_XML);

		TcpClient tcpClient = TcpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);

		try {
			String result = webClientBuilder.clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
					.build().post().uri("http://localhost:9090/customerWS/users").accept(MediaType.TEXT_XML)
					.contentType(MediaType.TEXT_XML).body(BodyInserters.fromObject(rBody)).retrieve()
					.bodyToMono(String.class).block();
			return ResponseEntity.ok().headers(headers).body(result);
		} catch (Exception e) {
			return ResponseEntity.ok().body(e.toString());
		}
	}

	@PostMapping("/theSoapConnectorWay")
	public String getUserWithModels() {
		return null;
	}

	public SOAPMessage createSoapRequest() throws SOAPException, IOException {
		/* Soap Message */
		MessageFactory mfc = MessageFactory.newInstance();
		SOAPMessage soapMessage = mfc.createMessage();

		SOAPPart soapPart = soapMessage.getSOAPPart();
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("us", "http://june.com/customerwsdlmodel");
		envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
		envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		envelope.addNamespaceDeclaration("m", "http://antispam.webservice.optenet.com");

		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElement = soapBody.addChildElement("ValidateUser", "m").addAttribute(envelope.createName("xmlns:n"), "http://antispam.webservice.optenet.com");
		
		SOAPElement soapElementChild = soapBodyElement.addChildElement("String", "xsi", "uri");
		soapElementChild.addTextNode("NinaPark");

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", "http://june.com/customerwsdlmodel/users");
		
		
		  System.out.println("Request SOAP Message:"); 
		  soapMessage.writeTo(System.out);
		  System.out.println("\n");
		  System.out.println(soapMessage.getMimeHeaders().getHeader("SOAPAction"));
		 
		
		/* End Soap Envelope */
		
		return soapMessage;

	}

	@GetMapping("saajCall")
	public SOAPEnvelope /*ResponseEntity<SOAPEnvelope>*/ callWs() throws Exception {

		String endpoint = "http://localhost:9090/customerWS/users";
		
		final String rBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:us=\"http://june.com/customerwsdlmodel\">" +
				"<soapenv:Header/>" + 
				"<soapenv:Body>" + 
				"<us:getUserRequest>" + 
				"<us:name>BullockGriffith</us:name>" + 
				"</us:getUserRequest>" + 
				"</soapenv:Body>" + 
				"</soapenv:Envelope>";
		
		InputStream is = new ByteArrayInputStream(rBody.getBytes());
		SOAPMessage request = MessageFactory.newInstance().createMessage(null, is);
		System.out.println("Request SOAP Message:"); 
		request.writeTo(System.out);
		System.out.println("\n");
		
		try { 
			HttpHeaders responseHeaders = new HttpHeaders();
		  responseHeaders.setContentType(MediaType.TEXT_XML);
		  
		  
		  SOAPConnectionFactory connectionFactory =
		  SOAPConnectionFactory.newInstance(); SOAPConnection soapConnection =
		  connectionFactory.createConnection();
		  
		  SOAPMessage response = soapConnection.call(request, endpoint); 
		  return response.getSOAPPart().getEnvelope();
		  
		  } catch (Exception e) { return null; }
		 
		/* End Soap Call */

	}
	
	@GetMapping("saajCallWH")
	public WSResponse /*ResponseEntity<SOAPEnvelope>*/ callWSWH() throws Exception {

		String endpoint = "http://localhost:9090/customerWS/users";
		
		final String rBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:us=\"http://june.com/customerwsdlmodel\">" +
				"<soapenv:Header/>" + 
				"<soapenv:Body>" + 
				"<us:getUserRequest>" + 
				"<us:name>BullockGriffith</us:name>" + 
				"</us:getUserRequest>" + 
				"</soapenv:Body>" + 
				"</soapenv:Envelope>";
		
		InputStream is = new ByteArrayInputStream(rBody.getBytes());
		SOAPMessage request = MessageFactory.newInstance().createMessage(null, is);
		System.out.println("Request SOAP Message:"); 
		request.writeTo(System.out);
		System.out.println("\n");
		
		try {
			  SOAPConnectionFactory connectionFactory = SOAPConnectionFactory.newInstance(); 
			  SOAPConnection soapConnection = connectionFactory.createConnection();
			  
			  if (request.getSOAPPart().getEnvelope().getHeader() != null) {
				  request.getSOAPPart().getEnvelope().getHeader().detachNode();
			  }
			  
			  request.getSOAPPart().getEnvelope().addHeader().addHeaderElement(new QName("header","headervalue"));
			  request.getSOAPPart().getEnvelope().getHeader().addHeaderElement(new QName("headerII","headerIIvalue"));
			  request.saveChanges();
			  
			  SOAPMessage response = soapConnection.call(request, endpoint); 
			  soapConnection.close();
			  return new WSResponse(response.getSOAPPart().getEnvelope(), "Success", "null");
			  
		  } catch (Exception e) {
			  return new WSResponse(null, "Failed", e.toString());
		  }
		 
		/* End Soap Call */

	}

}