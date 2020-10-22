package ee.taltech.arete.java.response.hodor_studenttester;

import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@Deprecated(forRemoval = true)
@NoArgsConstructor
@AllArgsConstructor
public class HodorTestContext {

	private Integer count;

	private Long endDate;

	private String file;

	private Double grade;

	private Integer identifier;

	private String mode;

	private String name;

	private Integer passedCount;

	private Long startDate;

	private List<HodorUnitTest> unitTests;

	private Integer weight;

	private String welcomeMessage;
}
