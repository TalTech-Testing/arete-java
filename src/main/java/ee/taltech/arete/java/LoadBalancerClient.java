package ee.taltech.arete.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;
import ee.taltech.arete.java.request.AreteRequestDTO;
import ee.taltech.arete.java.request.hook.AreteTestUpdateDTO;
import ee.taltech.arete.java.response.arete.AreteResponseDTO;
import ee.taltech.arete.java.response.arete.SystemStateDTO;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LoadBalancerClient {

	private final ObjectMapper objectMapper = new ObjectMapper();
	private final String url;

	/**
	 * @param testerUrl: authentication service url: https://cs.ttu.ee/services/arete/api/v2/ - most likely
	 **/
	public LoadBalancerClient(String testerUrl) {
		this.url = testerUrl;
	}

	/**
	 * @return state of service
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
	 * @param request: request body
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

	/**
	 * @param request: request body
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

	/**
	 * @param image: image to update - java-tester for example
	 **/
	public void updateImage(String image) {
		try {
			HttpResponse<String> response = put(url + "/image/" + image, "");
		} catch (Exception e) {
			throw new AreteException(e);
		}
	}

	@SneakyThrows
	private HttpResponse<String> get(String postUrl) {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(postUrl))
				.GET()
				.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
				.build();

		return client.send(request, HttpResponse.BodyHandlers.ofString());

	}

	@SneakyThrows
	private HttpResponse<String> post(String postUrl, String data) {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(postUrl))
				.POST(HttpRequest.BodyPublishers.ofString(data))
				.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
				.build();

		return client.send(request, HttpResponse.BodyHandlers.ofString());

	}

	@SneakyThrows
	private HttpResponse<String> put(String postUrl, String data) {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(postUrl))
				.PUT(HttpRequest.BodyPublishers.ofString(data))
				.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
				.build();

		return client.send(request, HttpResponse.BodyHandlers.ofString());

	}

}
