package arete.java;

import arete.java.request.AreteRequest;
import arete.java.request.AreteTestUpdate;
import arete.java.response.AreteResponse;
import arete.java.response.SystemState;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AreteClient {

    ObjectMapper objectMapper = new ObjectMapper();
    String url;

    /**
     * @param testerUrl: testers ip with port or url. localhost:8098 if in tester machine.
     **/
    public AreteClient(String testerUrl) {
        this.url = testerUrl;
    }


    /**
     * @return Currently active submissions
     **/
    public AreteRequest[] requestActiveSubmissions() {
        try {
            HttpResponse<String> response = get(url + "/submissions/active");
            return objectMapper.readValue(response.body(), AreteRequest[].class);
        } catch (Exception e) {
            throw new AreteException(e);
        }
    }

    /**
     * @return state of tester
     **/
    public SystemState requestState() {
        try {
            HttpResponse<String> response = get(url + "/state");
            return objectMapper.readValue(response.body(), SystemState.class);
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
     * @param request: new debug mode
     *                 <p>
     * @return a boolean whether operation succeeded or not
     **/
    public Boolean requestDebug(Boolean request) {
        try {
            HttpResponse<String> response = get(url + "/debug/" + request);
            assert response.statusCode() == 202;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param request: request body
     *                 <p>
     * @return a response with the actual test results
     **/
    public AreteResponse requestSync(AreteRequest request) {
        try {
            HttpResponse<String> response = post(url + "/:testSync", objectMapper.writeValueAsString(request));
            return objectMapper.readValue(response.body(), AreteResponse.class);
        } catch (Exception e) {
            throw new AreteException(e);
        }
    }

    /**
     * @param request: request body
     *                 <p>
     * @return the received request and send the test results to returnUrl
     **/
    public AreteRequest requestAsync(AreteRequest request) {
        try {
            HttpResponse<String> response = post(url + "/:testAsync", objectMapper.writeValueAsString(request));
            return objectMapper.readValue(response.body(), AreteRequest.class);
        } catch (Exception e) {
            throw new AreteException(e);
        }
    }

    /**
     * @param request: request body to make tester update tests folder to run tests from.
     **/
    public void updateTests(AreteTestUpdate request) {
        try {
            HttpResponse<String> response = put(url + "/tests", objectMapper.writeValueAsString(request));
        } catch (Exception e) {
            throw new AreteException(e);
        }
    }

    /**
     * @param image: image to update - java-tester, python-tester, prolog-tester currently supported
     *               AreteTestUpdate request: request body to update tester image. For example python-tester was updated in docker.io
     **/
    public void updateImage(String image) {
        try {
            HttpResponse<String> response = put(url + "/image/" + image, "");
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
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());

    }

    private HttpResponse<String> post(String postUrl, String data) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(postUrl))
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());

    }

    private HttpResponse<String> put(String postUrl, String data) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(postUrl))
                .PUT(HttpRequest.BodyPublishers.ofString(data))
                .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());

    }

}

class AreteException extends RuntimeException {
    public AreteException(Exception e) {
        super(e);
    }
}
