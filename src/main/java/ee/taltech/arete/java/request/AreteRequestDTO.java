package ee.taltech.arete.java.request;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class AreteRequestDTO {

	@ApiModelProperty(value = "Where tester knows to look for exercise. https://github.com/envomp/Arete-runbook/blob/master/docs/SUB_TESTER_FOR_DEVELOPER.md")
	private String dockerContentRoot;

	@ApiModelProperty(value = "Value is sent to docker runner. https://github.com/envomp/Arete-runbook/blob/master/docs/SUB_TESTER_FOR_DEVELOPER.md")
	private String dockerExtra;

	@ApiModelProperty(value = "Where tester knows to look for student. https://github.com/envomp/Arete-runbook/blob/master/docs/SUB_TESTER_FOR_DEVELOPER.md")
	private String dockerTestRoot;

	@Builder.Default
	@ApiModelProperty(value = "Default docker timeout is 120 seconds")
	private Integer dockerTimeout = 120;

	@ApiModelProperty(value = "Where student mail is sent. Default is uniid@ttu.ee")
	private String eMail;

	@ApiModelProperty(value = "URL or ssh for student repository. Needed if student source isn't provided")
	private String gitStudentRepo;

	@ApiModelProperty(value = "URL or ssh for test repository. Needed if test source isn't provided")
	private String gitTestRepo;

	@ApiModelProperty(value = "Specify hash to test that specific hash. Otherwise the latest hash of student repository will be tested, if git student repo is present.")
	private String hash;

	@Builder.Default
	@ApiModelProperty(value = "Default priority is 5")
	private Integer priority = 5;

	@ApiModelProperty(value = "Default is last in url. https://gitlab.cs.ttu.ee/envomp/iti0102-2019.git > project = iti0102-2019. Specify project, if its not in last position.")
	private String project;

	@ApiModelProperty(value = "values that are returned the same way they were given in. Not saved by Arete")
	private JsonNode returnExtra;

	@ApiModelProperty(value = "URL where result is sent. Not needed when testing Sync, but needed, when Async")
	private String returnUrl;

	@ApiModelProperty(value = "Slugs to be tested. Automatically fetched by arete if left empty")
	private Set<String> slugs;

	@ApiModelProperty(value = "List of student source files. When provided a student repository this gets filled by Arete")
	private List<SourceFileDTO> source;

	@ApiModelProperty(value = "See here for list of available options: https://github.com/envomp/Arete-runbook/blob/master/docs/SUB_TESTER_FOR_TEACHER.md")
	private Set<String> systemExtra;

	@ApiModelProperty(value = "List of test source files. When provided a test repository this gets filled by Arete")
	private List<SourceFileDTO> testSource;

	@ApiModelProperty(value = "Image used for testing. Currently available are seen here: https://hub.docker.com/search?q=automatedtestingservice&type=image")
	private String testingPlatform;

	@ApiModelProperty(value = "When override testing timestamp. Useful for retesting. Otherwise current timestamp will be used")
	private Long timestamp;

	@ApiModelProperty(value = "If gitStudentRepo is used, default is second from the end in url. https://gitlab.cs.ttu.ee/envomp/iti0102-2019.git > uniid = envomp. Specify uniid, if its not second from end or when repository is not provided. Otherwise not needed.")
	private String uniid;
}
