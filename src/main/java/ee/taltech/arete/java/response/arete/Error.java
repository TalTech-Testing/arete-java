package ee.taltech.arete.java.response.arete;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonClassDescription("Occured style, compilation and other errors")
public class Error {

	@Builder.Default
	@ApiModelProperty(value = "Error message")
	String message = "";

	@Builder.Default
	@ApiModelProperty(value = "Error kind(styleError, compilationError, other)")
	String kind = "";

	@Builder.Default
	@ApiModelProperty(value = "File, where error occured")
	String fileName = "";

	@Builder.Default
	@ApiModelProperty(value = "Line, where error occured")
	Integer lineNo = 0;

	@Builder.Default
	@ApiModelProperty(value = "Column, where error occured")
	Integer columnNo = 0;

	@Builder.Default
	@ApiModelProperty(value = "Hint, to fix the error")
	String hint = "";

}
