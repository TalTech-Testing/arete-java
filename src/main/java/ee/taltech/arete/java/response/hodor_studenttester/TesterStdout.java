package ee.taltech.arete.java.response.hodor_studenttester;

import lombok.*;

@Data
@Builder
@ToString
@Deprecated(forRemoval = true)
@NoArgsConstructor
@AllArgsConstructor
public class TesterStdout {

	String thread;

	Boolean truncated;

	String content;
}
