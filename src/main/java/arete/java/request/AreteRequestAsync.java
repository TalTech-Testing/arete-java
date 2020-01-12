package arete.java.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.google.common.net.HttpHeaders;
import com.sun.istack.NotNull;
import lombok.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonClassDescription("Async request from Moodle")
public class AreteRequestAsync extends AreteRequest {

    @NotNull
    @JsonPropertyDescription("Image used for testing. Currently available: [java, python]")
    private String testingPlatform;

    @NotNull
    @JsonPropertyDescription("URL where result is sent.")
    private String returnUrl;

    @NotNull
    @JsonPropertyDescription("URL or ssh for student repository")
    private String gitStudentRepo;

    @JsonPropertyDescription("URL or ssh for test repository. (This is rarely needed)")
    private String gitTestSource;

    @JsonPropertyDescription("Specify hash to test that specific hash. Otherwise the latest hash of student repository will be tested.")
    private String hash;
    @JsonPropertyDescription("Default is second from the end in url. https://gitlab.cs.ttu.ee/envomp/iti0102-2019.git > uniid = envomp. Specify uniid, if its not second from end")
    private String uniid;
    @JsonPropertyDescription("Default is last in url. https://gitlab.cs.ttu.ee/envomp/iti0102-2019.git > project = iti0102-2019. Specify project, if its not in last position.")
    private String project;

    @JsonPropertyDescription("No defaults. You can add (stylecheck) or something. It is sent to smaller tester. Look the possibilities from the small tester repository for more details.")
    private HashSet<String> dockerExtra;
    @JsonPropertyDescription("No defaults. You can add (noMail, noTesterFiles, noStd, noFeedback)")
    private HashSet<String> systemExtra;
    @JsonPropertyDescription("Default docker timeout is 120 seconds")
    private Integer dockerTimeout;
    @JsonPropertyDescription("Default priority is 5")
    private Integer priority;

    @JsonPropertyDescription("Security measurement")
    private String token;

}
