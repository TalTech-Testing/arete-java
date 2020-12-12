package ee.taltech.arete.java.response.hodor_studenttester;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;

@Data
@Builder
@ToString
@Deprecated(forRemoval = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HodorStudentTesterResponse {

	private String contentRoot;

	private String extra;

	private ArrayList<TestingResult> results;

	private String testRoot;

	private String type;

	private String version;
}
