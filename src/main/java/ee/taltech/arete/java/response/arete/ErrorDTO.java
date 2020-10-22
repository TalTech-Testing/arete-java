package ee.taltech.arete.java.response.arete;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonClassDescription("Occured style, compilation and other errors")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDTO {

	@Builder.Default
	@ApiModelProperty(value = "Column, where error occured")
	private Integer columnNo = 0;

	@ApiModelProperty(value = "FileDTO, where error occured")
	private String fileName;

	@ApiModelProperty(value = "Hint, to fix the error")
	private String hint;

	@Builder.Default
	@ApiModelProperty(value = "ErrorDTO kind(styleError, compilationError, other)")
	private String kind = "other";

	@Builder.Default
	@ApiModelProperty(value = "Line, where error occured")
	private Integer lineNo = 0;

	@ApiModelProperty(value = "ErrorDTO message")
	private String message;
}
