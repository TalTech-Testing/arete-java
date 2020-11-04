package ee.taltech.arete.java.request.tester;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DockerParameters {
	private final String uniid;

	@Builder.Default
	private final Set<String> systemExtra = new HashSet<>();

	@Builder.Default
	private final Integer timeout = 120;

	private final String commitMessage;

	@Builder.Default
	private final String contentRoot = "/student";

	private final String extra;

	@Builder.Default
	private final String testRoot = "/tester";
}
