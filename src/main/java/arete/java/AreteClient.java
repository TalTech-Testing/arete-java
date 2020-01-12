package arete.java;

import arete.java.dev.SubmissionInitializer;
import arete.java.request.AreteRequestAsync;
import arete.java.request.AreteRequestSync;
import arete.java.request.AreteTestUpdate;
import arete.java.response.AreteResponse;
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
     * String url: testers ip with port or url. localhost:8098 if in tester machine.
     **/
    AreteClient(String testerUrl) {
        this.url = testerUrl;
    }

    /**
     * @param request: request body
     * <p>
     * @return a response with the actual test results
     **/
    public AreteResponse requestSync(AreteRequestSync request) {
        try {
            HttpResponse<String> response = post(url + "/test/sync", objectMapper.writeValueAsString(request));
            return objectMapper.readValue(response.body(), AreteResponse.class);
        } catch (Exception e) {
            throw new AreteException(e);
        }
    }

    /**
     * @param request: request body
     * <p>
     * @return the received request and send the test results to returnUrl
     **/
    public AreteRequestAsync requestAsync(AreteRequestAsync request) {
        try {
            HttpResponse<String> response = post(url + "/test", objectMapper.writeValueAsString(request));
            return objectMapper.readValue(response.body(), AreteRequestAsync.class);
        } catch (Exception e) {
            throw new AreteException(e);
        }
    }

    /**
     * @param request: request body to make tester update tests folder to run tests from.
     **/
    public void updateTests(AreteTestUpdate request) {
        try {
            HttpResponse<String> response = post(url + "/tests/update", objectMapper.writeValueAsString(request));
        } catch (Exception e) {
            throw new AreteException(e);
        }
    }

    /**
     * @param image: image to update - java-tester, python-tester, prolog-tester currently supported
     * AreteTestUpdate request: request body to update tester image. For example python-tester was updated in docker.io
     **/
    public void updateImage(String image) {
        try {
            HttpResponse<String> response = post(url + "/image/update/" + image, "");
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
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());

    }

}

class AreteException extends RuntimeException {
    public AreteException(Exception e) {
        super(e);
    }
}
