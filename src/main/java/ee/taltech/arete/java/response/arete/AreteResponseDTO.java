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

	@Builder.Default
	private String type = "arete";

	@Builder.Default
	private String version = "2.0";

	@Builder.Default
	@ApiModelProperty(value = "List of style, compilation and other errors")
	private List<ErrorDTO> errors = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "List of student files")
	private List<FileDTO> files = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "List of test files")
	private List<FileDTO> testFiles = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "List of test suites which each contains unit-tests. Each test file produces an test suite")
	private List<TestContextDTO> testSuites = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "Console outputs from docker")
	private List<ConsoleOutputDTO> consoleOutputs = new ArrayList<>();

	@ApiModelProperty(value = "HTML result for student")
	private String output;

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
	@ApiModelProperty(value = "DockerTestRunner image used for testing")
	private String testingPlatform = "unknown";

	@ApiModelProperty(value = "Git path with namespace. iti0102-2019/ex for example")
	private String root;

	@ApiModelProperty(value = "URL or ssh for test repository")
	private String gitTestRepo;

	@ApiModelProperty(value = "URL or ssh for student repository")
	private String gitStudentRepo;

	@Builder.Default
	@ApiModelProperty(value = "Style percentage. Either from 0 to 100")
	private Integer style = 100;

	@ApiModelProperty(value = "Slug ran for student. for example pr01_something")
	private String slug;

	@ApiModelProperty(value = "values that are returned the same way they were given in")
	private JsonNode returnExtra;

	@ApiModelProperty(value = "CommitDTO hash from student git repository")
	private String hash;

	@ApiModelProperty(value = "Students uniid")
	private String uniid;

	@ApiModelProperty(value = " Students mail")
	private String email;

	@ApiModelProperty(value = " Testing timestamp in milliseconds")
	private Long timestamp;

	@ApiModelProperty(value = " Time when submission was received in milliseconds")
	private Long receivedTimestamp;

	@ApiModelProperty(value = " Timestamp when testing was finished in milliseconds")
	private Long finishedTimestamp;

	@ApiModelProperty(value = "Commit message by student when pushing to repository")
	private String commitMessage;

	@Builder.Default
	@ApiModelProperty(value = "Priority of job on a scale from 1 to 10 inclusive")
	private Integer priority = 5;

	@Builder.Default
	@ApiModelProperty(value = "You can add (stylecheck) or something. It is sent to smaller tester. Look the possibilities from the small tester repository for more details. Values will be joined by comma before sending to tester")
	private Set<String> dockerExtra = new HashSet<>();

	@Builder.Default
	@ApiModelProperty(value = "Extra parameters for testing")
	private Set<String> systemExtra = new HashSet<>();

	@Builder.Default
	@ApiModelProperty(value = "Default docker timeout is 120 seconds. Maximum allowed code execution time.")
	private Integer dockerTimeout = 120;

	@Builder.Default
	@ApiModelProperty(value = "Whether the testing was successful or not. Will be true if tester crashed.")
	private Boolean failed = false;

}
