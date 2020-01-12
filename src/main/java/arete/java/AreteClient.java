package arete.java;

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


    /**
     * String url: testers ip with port or url
     * AreteRequestSync request: request body
     * <p>
     * Sync will return a response with the actual test results
     **/
    public AreteResponse requestSync(String url, AreteRequestSync request) throws IOException, InterruptedException {
        HttpResponse<String> response = post(url, objectMapper.writeValueAsString(request));
        return objectMapper.readValue(response.body(), AreteResponse.class);
    }

    /**
     * String url: testers ip with port or url
     * AreteRequestAsync request: request body
     * <p>
     * Async will return the received request and send the test results to returnUrl
     **/
    public AreteRequestAsync requestAsync(String url, AreteRequestAsync request) throws IOException, InterruptedException {
        HttpResponse<String> response = post(url, objectMapper.writeValueAsString(request));
        return objectMapper.readValue(response.body(), AreteRequestAsync.class);
    }

    /**
     * String url: testers ip with port or url
     * AreteTestUpdate request: request body to make tester update tests folder to run tests from.
     **/
    public void updateTests(String url, AreteTestUpdate request) throws IOException, InterruptedException {
        HttpResponse<String> response = post(url, objectMapper.writeValueAsString(request));
    }

    /**
     * String url: testers ip with port or url, for example localhost:8098/image/update/java-tester
     * AreteTestUpdate request: request body to update tester image. For example python-tester was updated in docker.io
     **/
    public void updateImage(String url) throws IOException, InterruptedException {
        HttpResponse<String> response = post(url, "");
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
