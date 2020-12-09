package ee.taltech.arete.java.response.hodor_studenttester;

import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@Deprecated(forRemoval = true)
@NoArgsConstructor
@AllArgsConstructor
public class HodorUnitTest {

	private List<String> groupsDependedUpon;

	private String status;

	private Integer weight;

	private Boolean printExceptionMessage;

	private Boolean printStackTrace;

	private Long timeElapsed;

	private List<String> methodsDependedUpon;

	private String stackTrace;

	private String name;

	private List<ConsoleOutputDTO> stdout;

	private String exceptionClass;

	private String exceptionMessage;

	private List<ConsoleOutputDTO> stderr;

}