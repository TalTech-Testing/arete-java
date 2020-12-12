package ee.taltech.arete.java.response.hodor_studenttester;

import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@Deprecated(forRemoval = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HodorUnitTest {

	private String status;

	private Integer weight;

	private String description;

	private Boolean printExceptionMessage;

	private Boolean printStackTrace;

	private Long timeElapsed;

	private List<String> groupsDependedUpon;

	private List<String> methodsDependedUpon;

	private String name;

	private String stackTrace;

	private String exceptionClass;

	private String exceptionMessage;

	private List<ConsoleOutputDTO> stdout;

	private List<ConsoleOutputDTO> stderr;

}