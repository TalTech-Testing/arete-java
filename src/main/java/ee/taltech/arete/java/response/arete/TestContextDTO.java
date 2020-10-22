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
@JsonClassDescription("Test results from test file")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestContextDTO {

	@Builder.Default
	@ApiModelProperty(value = "List of unittests tested")
	private List<UnitTestDTO> unitTests = new ArrayList<>();

	@ApiModelProperty(value = "Test name")
	private String name;

	@ApiModelProperty(value = "Test file path")
	private String file;

	@ApiModelProperty(value = "Test start time in milliseconds")
	private Long startDate;

	@ApiModelProperty(value = "Test end time in milliseconds")
	private Long endDate;

	@Builder.Default
	@ApiModelProperty(value = "Sum of test weights")
	private Integer weight = 1;

	@Builder.Default
	@ApiModelProperty(value = "Number of passed tests")
	private Integer passedCount = 0;

	@Builder.Default
	@ApiModelProperty(value = "Total grade for this test file")
	private Double grade = 0.0;

}
