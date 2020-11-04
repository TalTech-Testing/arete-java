package ee.taltech.arete.java.request.tester;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonClassDescription("Input that TestRunner gets")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DockerParameters {
	private String uniid;

	@Builder.Default
	private Set<String> systemExtra = new HashSet<>();

	@Builder.Default
	private Integer timeout = 120;

	private String commitMessage;

	@Builder.Default
	private String contentRoot = "/student";

	private String extra;

	@Builder.Default
	private String testRoot = "/tester";
}
