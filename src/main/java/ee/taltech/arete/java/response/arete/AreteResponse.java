package ee.taltech.arete.java.response.arete;

import ee.taltech.arete.java.TestingEnvironment;
import ee.taltech.arete.java.UvaConfiguration;
import com.fasterxml.jackson.annotation.JsonClassDescription;
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
public class AreteResponse {

	@Builder.Default
	String type = "arete";

	@Builder.Default
	String version = "arete_2.0";

	@Builder.Default
	@ApiModelProperty(value = "List of style, compilation and other errors")
	List<Error> errors = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "List of student files")
	List<File> files = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "List of test files")
	List<File> testFiles = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "List of test suites which each contains unit-tests. Each test file produces an test suite")
	List<TestContext> testSuites = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "(Appended by arete) Console outputs from docker")
	List<ConsoleOutput> consoleOutputs = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete) HTML result for student")
	String output = "";

	@Builder.Default
	@ApiModelProperty(value = "Number of tests")
	Integer totalCount = 0;

	@Builder.Default
	@ApiModelProperty(value = "Passed percentage")
	Double totalGrade = 0.0;

	@Builder.Default
	@ApiModelProperty(value = "Number of passed tests")
	Integer totalPassedCount = 0;

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete) DockerTestRunner image used for testing")
	String testingPlatform = "";

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete) git path with namespace. iti0102-2019/ex for example")
	String root = "";

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete) URL or ssh for test repository")
	String gitTestRepo = "";

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete) URL or ssh for student repository")
	String gitStudentRepo = "";

	@Builder.Default
	@ApiModelProperty(value = "Style percentage. Either from 0 to 100")
	Integer style = 100;

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete) Slug ran for student. for example pr01_something")
	String slug = "";

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete) values that are returned the same way they were given in")
	JsonNode returnExtra = null;

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete) Commit hash from student git repository")
	String hash = "";

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete) Students uniid")
	String uniid = "";

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete if left empty) Students mail")
	String email = "";

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete if left empty) Testing timestamp in milliseconds")
	Long timestamp = 0L;

	@Builder.Default
	@ApiModelProperty(value = "Time when submission was received in milliseconds")
	Long receivedTimestamp = 0L;

	@Builder.Default
	@ApiModelProperty(value = "Timestamp when testing was finished in milliseconds")
	Long finishedTimestamp = 0L;

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete) Commit message by student when pushing to repository")
	String commitMessage = "";

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete) Priority of job on a scale from 1 to 10 inclusive")
	Integer priority = 5;

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete if left empty) No defaults. You can add (stylecheck) or something. It is sent to smaller tester. Look the possibilities from the small tester repository for more details.")
	private Set<String> dockerExtra = new HashSet<>();

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete) No defaults. You can add (anonymous, noMail, noFiles, noTesterFiles, noStudentFiles, noStd, noOverride, noFeedback, minimalFeedback)")
	private Set<String> systemExtra = new HashSet<>();

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete) Default docker timeout is 120 seconds. Maximum allowed code execution time.")
	private Integer dockerTimeout = 120;

	@Builder.Default
	@ApiModelProperty(value = "(Overridden by arete if left empty) Whether the testing was successful or not. Will be true if tester crashed.")
	Boolean failed = false;

	@Builder.Default
	@ApiModelProperty(value = "Testing environment")
	private TestingEnvironment testingEnvironment = TestingEnvironment.DOCKER;

	@ApiModelProperty(value = "When using TestingEnvironment.UVA. Used configuration appears here")
	private UvaConfiguration uvaConfiguration; // when using TestingEnvironment.UVA

}
