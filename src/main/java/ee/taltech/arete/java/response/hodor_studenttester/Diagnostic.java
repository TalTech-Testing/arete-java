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
public class Diagnostic {

	private String affected;

	private String code;

	private Integer columnNo;

	private String file;

	private String hint;

	private String kind;

	private Integer lineNo;

	private String message;

	private Boolean sensitive;
}

