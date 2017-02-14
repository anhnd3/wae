package vn.wae.spring.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HttpClientUtils {

	private RestTemplate rest;
	private HttpHeaders headers;
	private HttpStatus status;

	public HttpClientUtils() {
		this.rest = new RestTemplate();
		this.headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "*/*");
	}

	public String get(String url) {
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
		ResponseEntity<String> responseEntity = rest.exchange(url, HttpMethod.GET, requestEntity, String.class);
		this.setStatus(responseEntity.getStatusCode());
		return responseEntity.getBody();
	}

	public String post(String url, String json) {
		HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
		ResponseEntity<String> responseEntity = rest.exchange(url, HttpMethod.POST, requestEntity, String.class);
		this.setStatus(responseEntity.getStatusCode());
		return responseEntity.getBody();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
