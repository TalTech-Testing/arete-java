package ee.taltech.arete.java.request;

import ee.taltech.arete.java.TestingEnvironment;
import ee.taltech.arete.java.UvaConfiguration;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonClassDescription("Async request from Moodle")
public class AreteRequest {

	@ApiModelProperty(value = "Image used for testing. Currently available: [java, python, fsharp, prolog]")
	private String testingPlatform;

	@ApiModelProperty(value = "URL where result is sent.")
	private String returnUrl;

	@ApiModelProperty(value = "URL or ssh for student repository")
	private String gitStudentRepo;
	// or. One of the options must be chosen
	@ApiModelProperty(value = "List of student source files")
	private List<SourceFile> source;

	@ApiModelProperty(value = "URL or ssh for test repository")
	private String gitTestRepo;
	//or
	@ApiModelProperty(value = "List of test source files")
	private List<SourceFile> testSource;

	@ApiModelProperty(value = "Slugs to be tested")
	private Set<String> slugs;

	@ApiModelProperty(value = "Specify hash to test that specific hash. Otherwise the latest hash of student repository will be tested, if git student repo is present.")
	private String hash;

	@ApiModelProperty(value = "If gitStudentRepo is used, default is second from the end in url. https://gitlab.cs.ttu.ee/envomp/iti0102-2019.git > uniid = envomp. Specify uniid, if its not second from end. Otherwise not needed.")
	private String uniid;

	@ApiModelProperty(value = "Where student mail is sent. Default is uniid@ttu.ee")
	private String eMail;

	@ApiModelProperty(value = "Default is last in url. https://gitlab.cs.ttu.ee/envomp/iti0102-2019.git > project = iti0102-2019. Specify project, if its not in last position.")
	private String project;

	@ApiModelProperty(value = "No defaults. You can add (stylecheck) or something. It is sent to smaller tester. Look the possibilities from the small tester repository for more details.")
	private Set<String> dockerExtra;

	@ApiModelProperty(value = "No defaults. You can add (anonymous, noOverride, noMail, noFiles, noTesterFiles, noStudentFiles, noStd, noFeedback, minimalFeedback, noFun)")
	private Set<String> systemExtra;

	@ApiModelProperty(value = "Default docker timeout is 120 seconds")
	private Integer dockerTimeout;

	@ApiModelProperty(value = "Default priority is 5")
	private Integer priority;

	@ApiModelProperty(value = "When override testing timestamp")
	private Long timestamp;

	@ApiModelProperty(value = "values that are returned the same way they were given in")
	private JsonNode returnExtra;

	@Builder.Default
	@ApiModelProperty(value = "Testing environment")
	private TestingEnvironment testingEnvironment = TestingEnvironment.DOCKER;

	@ApiModelProperty(value = "When using TestingEnvironment.UVA. Add configuration to here")
	private UvaConfiguration uvaConfiguration; // when using TestingEnvironment.UVA
}
