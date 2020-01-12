package arete.java.response;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonClassDescription("Response sent to Moodle")
public class AreteResponse {

    String version = "arete_2.0";

    @JsonPropertyDescription("List of style, compilation and other errors")
    List<Error> errors = new ArrayList<>();

    @JsonPropertyDescription("List of student files")
    List<File> files = new ArrayList<>();

    @JsonPropertyDescription("List of test files")
    List<File> testFiles = new ArrayList<>();

    @JsonPropertyDescription("List of test suites which each contains unit-tests. Each test file produces an test suite")
    List<TestContext> testSuites = new ArrayList<>();

    @JsonPropertyDescription("Console outputs from docker")
    List<ConsoleOutput> consoleOutputs = new ArrayList<>();

    @JsonPropertyDescription("HTML result for student")
    String output;

    @JsonPropertyDescription("Number of tests")
    Integer totalCount = 0;

    @JsonPropertyDescription("Passed percentage")
    String totalGrade = "0";

    @JsonPropertyDescription("Number of passed tests")
    Integer totalPassedCount = 0;

    @JsonPropertyDescription("Style percentage")
    Integer style = 100;

    @JsonPropertyDescription("Slug ran for student. for example pr01_something")
    String slug;

    @JsonPropertyDescription("Security Token")
    String token;

    @JsonPropertyDescription("Commit hash from gitlab")
    String hash;

    @JsonPropertyDescription("Students uniid")
    String uniid;

    @JsonPropertyDescription("Testing timestamp")
    Long timestamp;

    @JsonPropertyDescription("Commit message for student repository")
    String commitMessage;

}
