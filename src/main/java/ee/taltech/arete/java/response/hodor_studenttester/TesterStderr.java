package ee.taltech.arete.java.response.hodor_studenttester;


import lombok.*;

@Data
@Builder
@ToString
@Deprecated(forRemoval = true)
@NoArgsConstructor
@AllArgsConstructor
public class TesterStderr {

	String thread;

	Boolean truncated;

	String content;

}
