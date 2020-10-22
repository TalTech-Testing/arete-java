package ee.taltech.arete.java.response.hodor_studenttester;

import lombok.*;

@Data
@Builder
@ToString
@Deprecated(forRemoval = true)
@NoArgsConstructor
@AllArgsConstructor
public class HodorFile {

	private String contents;

	private Boolean isTest;

	private String path;
}
