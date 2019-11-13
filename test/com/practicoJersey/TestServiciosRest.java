package com.practicoJersey;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import generic.EMF;

public class TestServiciosRest {

	public final String BASE_URL="http://localhost:8080/Practico-Especial/api";

	public final HttpClient client = HttpClientBuilder.create().build();

	@Test
	public void testRESTInterface() throws ClientProtocolException, IOException {
		//testAltaUser();
		testAcopiosByIdUser(2,"2019-01-01","2019-12-01");
		testRecoleccionesByGeolocalizacion(3);
	}
	
	public void testAltaUser() throws ClientProtocolException, IOException {

		String url = BASE_URL + "/usuarios";

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode jsonObject = mapper.createObjectNode();
		jsonObject.put("nombre", "Jorge");
		jsonObject.put("apellido", "Lopez");
		jsonObject.put("dni", 7);
		jsonObject.put("email", "Jorge.Lopez@gmail.com");
		jsonObject.put("calle", "Juncal");
		jsonObject.put("numero", 472);
		jsonObject.put("latGeoposicion", -37.335440);
		jsonObject.put("longGeoposicion", -59.133295);
		String jsonString = jsonObject.toString();

		HttpPost post = new HttpPost(url);
		post.setEntity(new StringEntity(jsonString, ContentType.APPLICATION_JSON));
		HttpResponse response = client.execute(post);

		System.out.println("\nPOST "+url);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		String resultContent = getResultContent(response);
		System.out.println("Response Content : " + resultContent);


	}

	private String getResultContent(HttpResponse response) throws IOException {
		HttpEntity entity = response.getEntity();
		if(entity!=null) {
			BufferedReader rd = new BufferedReader(new InputStreamReader(entity.getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		}else {
			return "";
		}
	}

	
	public void testAcopiosByIdUser(int id,String fecA,String fecB) throws ClientProtocolException, IOException {

		String url = BASE_URL + "/servicios/usuario/"+id+"/fechaI/"+fecA+"/fechaF/"+fecB;
		System.out.println(url);
		HttpGet request = new HttpGet(url);

		HttpResponse response = client.execute(request);
		
		System.out.println("\nGET "+url);

		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		String resultContent = getResultContent(response);

		System.out.println("Response Content : " + resultContent);

	}

	
	
	private void testRecoleccionesByGeolocalizacion(int id) throws ClientProtocolException, IOException {
		
		String url = BASE_URL + "/servicios/usuario/"+id+"/lugares";

		HttpGet request = new HttpGet(url);

		HttpResponse response = client.execute(request);

		System.out.println("\nGET "+url);
		
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		String resultContent = getResultContent(response);

		System.out.println("Response Content : " + resultContent);
		
	}
	
}
