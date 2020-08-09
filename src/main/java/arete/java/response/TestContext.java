package arete.java.response;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonClassDescription("Test results from test file")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestContext {

	@JsonPropertyDescription("List of unittests tested")
	List<UnitTest> unitTests;

	@JsonPropertyDescription("Test name")
	String name;

	@JsonPropertyDescription("Test file path")
	String file;

	@JsonPropertyDescription("Test start time")
	Long startDate;

	@JsonPropertyDescription("Test end time")
	Long endDate;

//	String mode;
//	String welcomeMessage;
//	Integer identifier;
//	Integer count;

	@JsonPropertyDescription("Sum of test weights")
	Integer weight;

	@JsonPropertyDescription("Number of passed tests")
	Integer passedCount;

	@JsonPropertyDescription("Total grade for this test file")
	Double grade;

}
