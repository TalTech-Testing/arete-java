package ee.taltech.arete.java.response.arete;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonClassDescription("Response sent to ReturnUrl")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AreteResponseDTO {

	@ApiModelProperty(value = "Commit message by student when pushing to repository")
	private String commitMessage;

	@Builder.Default
	@ApiModelProperty(value = "Console outputs from docker")
	private List<ConsoleOutputDTO> consoleOutputs = new ArrayList<>();

	@ApiModelProperty(value = "content root that was sent to tester")
	private String dockerContentRoot;

	@ApiModelProperty(value = "Extra parameters that were sent to tester")
	private String dockerExtra;

	@ApiModelProperty(value = "test root that was sent to tester")
	private String dockerTestRoot;

	@Builder.Default
	@ApiModelProperty(value = "Default docker timeout is 120 seconds. Maximum allowed code execution time.")
	private Integer dockerTimeout = 120;

	@ApiModelProperty(value = " Students mail")
	private String email;

	@Builder.Default
	@ApiModelProperty(value = "List of style, compilation and other errors")
	private List<ErrorDTO> errors = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "Whether the testing was successful or not. Will be true if tester crashed.")
	private Boolean failed = false;

	@Builder.Default
	@ApiModelProperty(value = "List of student files")
	private List<FileDTO> files = new ArrayList<>();

	@ApiModelProperty(value = " Timestamp when testing was finished in milliseconds")
	private Long finishedTimestamp;

	@ApiModelProperty(value = "URL or ssh for student repository")
	private String gitStudentRepo;

	@ApiModelProperty(value = "URL or ssh for test repository")
	private String gitTestRepo;

	@ApiModelProperty(value = "CommitDTO hash from student git repository")
	private String hash;

	@ApiModelProperty(value = "HTML result for student")
	private String output;

	@Builder.Default
	@ApiModelProperty(value = "Priority of job on a scale from 1 to 10 inclusive")
	private Integer priority = 5;

	@ApiModelProperty(value = " Time when submission was received in milliseconds")
	private Long receivedTimestamp;

	@ApiModelProperty(value = "values that are returned the same way they were given in")
	private JsonNode returnExtra;

	@ApiModelProperty(value = "Git path with namespace. iti0102-2019/ex for example")
	private String root;

	@ApiModelProperty(value = "Slug ran for student. for example pr01_something")
	private String slug;

	@Builder.Default
	@ApiModelProperty(value = "Style percentage. Either from 0 to 100")
	private Integer style = 100;

	@Builder.Default
	@ApiModelProperty(value = "Extra parameters used for testing")
	private Set<String> systemExtra = new HashSet<>();

	@Builder.Default
	@ApiModelProperty(value = "List of test files")
	private List<FileDTO> testFiles = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "List of test suites which each contains unit-tests. Each test file produces an test suite")
	private List<TestContextDTO> testSuites = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "DockerTestRunner image used for testing")
	private String testingPlatform = "unknown";

	@ApiModelProperty(value = " Testing timestamp in milliseconds")
	private Long timestamp;

	@Builder.Default
	@ApiModelProperty(value = "Number of tests")
	private Integer totalCount = 0;

	@Builder.Default
	@ApiModelProperty(value = "Passed percentage")
	private Double totalGrade = 0.0;

	@Builder.Default
	@ApiModelProperty(value = "Number of passed tests")
	private Integer totalPassedCount = 0;

	@Builder.Default
	private String type = "arete";

	@ApiModelProperty(value = "Students uniid")
	private String uniid;

	@Builder.Default
	private String version = "2.0";
}

