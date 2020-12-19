package ee.taltech.arete.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;
import ee.taltech.arete.java.request.AreteRequestDTO;
import ee.taltech.arete.java.request.hook.AreteTestUpdateDTO;
import ee.taltech.arete.java.response.arete.AreteResponseDTO;
import ee.taltech.arete.java.response.arete.SystemStateDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AreteClient {

	ObjectMapper objectMapper = new ObjectMapper();

	String url;

	String token;

	/**
	 * @param testerUrl: testers ip with port or url. localhost:8098 if in tester machine.
	 **/
	public AreteClient(String testerUrl) {
		this.url = testerUrl;
		this.token = null;
	}

	/**
	 * @param testerUrl: testers ip with port or url. localhost:8098 if in tester machine.
	 **/
	public AreteClient(String testerUrl, String token) {
		this.url = testerUrl;
		this.token = token;
	}

	/**
	 * @return Currently active submissions
	 **/
	public AreteRequestDTO[] requestActiveSubmissions() {
		try {
			HttpResponse<String> response = get(url + "/submissions/active");
			return objectMapper.readValue(response.body(), AreteRequestDTO[].class);
		} catch (Exception e) {
			throw new AreteException(e);
		}
	}

	private HttpResponse<String> get(String postUrl) throws IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(postUrl))
				.GET()
				.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
				.setHeader(HttpHeaders.AUTHORIZATION, token)
				.build();

		return client.send(request, HttpResponse.BodyHandlers.ofString());

	}

	/**
	 * @return state of tester
	 **/
	public SystemStateDTO requestState() {
		try {
			HttpResponse<String> response = get(url + "/state");
			return objectMapper.readValue(response.body(), SystemStateDTO.class);
		} catch (Exception e) {
			throw new AreteException(e);
		}
	}

	/**
	 * @return logs of tester
	 **/
	public String requestLogs() {
		try {
			HttpResponse<String> response = get(url + "/logs");
			return response.body();
		} catch (Exception e) {
			throw new AreteException(e);
		}
	}

	/**
	 * @param request: request body
	 *                 <p>
	 * @return a response with the actual test results
	 **/
	public AreteResponseDTO requestSync(AreteRequestDTO request) {
		try {
			HttpResponse<String> response = post(url + "/:testSync", objectMapper.writeValueAsString(request));
			return objectMapper.readValue(response.body(), AreteResponseDTO.class);
		} catch (Exception e) {
			throw new AreteException(e);
		}
	}

	private HttpResponse<String> post(String postUrl, String data) throws IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(postUrl))
				.POST(HttpRequest.BodyPublishers.ofString(data))
				.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
				.setHeader(HttpHeaders.AUTHORIZATION, token)
				.build();

		return client.send(request, HttpResponse.BodyHandlers.ofString());

	}

	/**
	 * @param request: request body
	 *                 <p>
	 * @return the received request and send the test results to returnUrl
	 **/
	public AreteRequestDTO requestAsync(AreteRequestDTO request) {
		try {
			HttpResponse<String> response = post(url + "/:testAsync", objectMapper.writeValueAsString(request));
			return objectMapper.readValue(response.body(), AreteRequestDTO.class);
		} catch (Exception e) {
			throw new AreteException(e);
		}
	}

	/**
	 * @param request: request body to make tester update tests folder to run tests from.
	 **/
	public void updateTests(AreteTestUpdateDTO request) {
		try {
			HttpResponse<String> response = put(url + "/tests", objectMapper.writeValueAsString(request));
		} catch (Exception e) {
			throw new AreteException(e);
		}
	}

	private HttpResponse<String> put(String postUrl, String data) throws IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(postUrl))
				.PUT(HttpRequest.BodyPublishers.ofString(data))
				.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
				.setHeader(HttpHeaders.AUTHORIZATION, token)
				.build();

		return client.send(request, HttpResponse.BodyHandlers.ofString());

	}

	/**
	 * @param image: image to update - java-tester, python-tester, prolog-tester currently supported
	 *               AreteTestUpdateDTO request: request body to update tester image. For example python-tester was updated in docker.io
	 **/
	public void updateImage(String image) {
		try {
			HttpResponse<String> response = put(url + "/image/" + image, "");
		} catch (Exception e) {
			throw new AreteException(e);
		}
	}

}

class AreteException extends RuntimeException {
	public AreteException(Exception e) {
		super(e);
	}
}
