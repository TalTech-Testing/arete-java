package ee.taltech.arete.java.response.arete;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonClassDescription("Test results from test file")
public class TestContext {

	@Builder.Default
	@ApiModelProperty(value = "List of unittests tested")
	List<UnitTest> unitTests = new ArrayList<>();

	@Builder.Default
	@ApiModelProperty(value = "Test name")
	String name = "";

	@Builder.Default
	@ApiModelProperty(value = "Test file path")
	String file = "";

	@Builder.Default
	@ApiModelProperty(value = "Test start time in milliseconds")
	Long startDate = 0L;

	@Builder.Default
	@ApiModelProperty(value = "Test end time in milliseconds")
	Long endDate = 0L;

//	String mode;
//	String welcomeMessage;
//	Integer identifier;
//	Integer count;

	@Builder.Default
	@ApiModelProperty(value = "Sum of test weights")
	Integer weight = 0;

	@Builder.Default
	@ApiModelProperty(value = "Number of passed tests")
	Integer passedCount = 0;

	@Builder.Default
	@ApiModelProperty(value = "Total grade for this test file")
	Double grade = 0.0;

}
