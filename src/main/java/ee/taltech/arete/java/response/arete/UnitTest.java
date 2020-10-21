package ee.taltech.arete.java.response.arete;

import ee.taltech.arete.java.TestStatus;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonClassDescription("Unit test")
public class UnitTest {

	@ApiModelProperty(value = "Groups of unittests this unittest depends on. If any test fails in that group, this test is skipped")
	List<String> groupsDependedUpon;

	@ApiModelProperty(value = "Status of the unittest")
	TestStatus status;

	@ApiModelProperty(value = "Test weight")
	Integer weight;

	@ApiModelProperty(value = "Boolean whether to show exception message to student or not")
	Boolean printExceptionMessage;

	@ApiModelProperty(value = "Boolean whether to show stack trace to student or not")
	Boolean printStackTrace;

	@ApiModelProperty(value = "Time spent on test")
	Long timeElapsed;

	@ApiModelProperty(value = "Methods depended, otherwise skipped")
	List<String> methodsDependedUpon;

	@ApiModelProperty(value = "Stacktrace")
	String stackTrace;

	@ApiModelProperty(value = "Test name")
	String name;

	@ApiModelProperty(value = "List of stdouts")
	List<ConsoleOutput> stdout;

	@ApiModelProperty(value = "Exception class")
	String exceptionClass;

	@ApiModelProperty(value = "Exception message")
	String exceptionMessage;

	@ApiModelProperty(value = "List of stderrs")
	List<ConsoleOutput> stderr;
}
