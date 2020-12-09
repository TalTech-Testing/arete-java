package ee.taltech.arete.java.response.arete;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonClassDescription("Unit test")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnitTestDTO {

	@ApiModelProperty(value = "Exception class")
	private String exceptionClass;

	@ApiModelProperty(value = "Exception message")
	private String exceptionMessage;

	@Builder.Default
	@ApiModelProperty(value = "Groups of unittests this unittest depends on. If any test fails in that group, this test is skipped")
	private List<String> groupsDependedUpon = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "Methods depended, otherwise skipped")
	private List<String> methodsDependedUpon = new ArrayList<>();

	@ApiModelProperty(value = "Test name")
	private String name;

	@Builder.Default
	@ApiModelProperty(value = "Boolean whether to show exception message to student or not")
	private Boolean printExceptionMessage = false;

	@Builder.Default
	@ApiModelProperty(value = "Boolean whether to show stack trace to student or not")
	private Boolean printStackTrace = false;

	@ApiModelProperty(value = "Stacktrace")
	private String stackTrace;

	@Builder.Default
	@ApiModelProperty(value = "Status of the unittest")
	private TestStatus status = TestStatus.SKIPPED;

	@Builder.Default
	@ApiModelProperty(value = "List of stderrs")
	private String stderr;

	@Builder.Default
	@ApiModelProperty(value = "List of stdouts")
	private String stdout;

	@ApiModelProperty(value = "Time spent on test")
	private Long timeElapsed;

	@Builder.Default
	@ApiModelProperty(value = "Test weight")
	private Integer weight = 1;
}
