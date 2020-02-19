package arete.java.response;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonClassDescription("Response sent to Moodle")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AreteResponse {

    @Builder.Default
    String version = "arete_2.0";

    @Builder.Default
    @JsonPropertyDescription("List of style, compilation and other errors")
    List<Error> errors = new ArrayList<>();

    @Builder.Default
    @JsonPropertyDescription("List of student files")
    List<File> files = new ArrayList<>();

    @Builder.Default
    @JsonPropertyDescription("List of test files")
    List<File> testFiles = new ArrayList<>();

    @Builder.Default
    @JsonPropertyDescription("List of test suites which each contains unit-tests. Each test file produces an test suite")
    List<TestContext> testSuites = new ArrayList<>();

    @Builder.Default
    @JsonPropertyDescription("Console outputs from docker")
    List<ConsoleOutput> consoleOutputs = new ArrayList<>();

    @JsonPropertyDescription("HTML result for student")
    String output;

    @Builder.Default
    @JsonPropertyDescription("Number of tests")
    Integer totalCount = 0;

    @Builder.Default
    @JsonPropertyDescription("Passed percentage")
    String totalGrade = "0";

    @Builder.Default
    @JsonPropertyDescription("Number of passed tests")
    Integer totalPassedCount = 0;

    @JsonPropertyDescription("Docker image used for testing")
    String testingPlatform;

    @JsonPropertyDescription("git namespace")
    String root;

    @JsonPropertyDescription("URL or ssh for test repository")
    String gitTestRepo;

    @JsonPropertyDescription("URL or ssh for student repository")
    String gitStudentRepo;

    @Builder.Default
    @JsonPropertyDescription("Style percentage")
    Integer style = 100;

    @JsonPropertyDescription("Slug ran for student. for example pr01_something")
    String slug;

    @JsonPropertyDescription("values that are returned the same way they were given in")
    JsonNode returnExtra;

    @JsonPropertyDescription("Commit hash from gitlab")
    String hash;

    @JsonPropertyDescription("Students uniid")
    String uniid;

    @JsonPropertyDescription("Testing timestamp")
    Long timestamp;

    @JsonPropertyDescription("Commit message for student repository")
    String commitMessage;

    @JsonPropertyDescription("Priority of job")
    Integer priority;

    @JsonPropertyDescription("No defaults. You can add (stylecheck) or something. It is sent to smaller tester. Look the possibilities from the small tester repository for more details.")
    private Set<String> dockerExtra;

    @JsonPropertyDescription("No defaults. You can add (noMail, noFiles, noTesterFiles, noStudentFiles, noStd, noFeedback, minimalFeedback)")
    private Set<String> systemExtra;

    @JsonPropertyDescription("Default docker timeout is 120 seconds")
    private Integer dockerTimeout;

    @Builder.Default
    @JsonPropertyDescription("Whether the testing was successful or not")
    Boolean failed = false;

}
