package ee.taltech.arete.java.response.hodor_studenttester;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Builder
@ToString
@Deprecated(forRemoval = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TesterStdout {

	String thread;

	Boolean truncated;

	String content;
}
