package arete.java.response.arete;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonClassDescription("File class")
public class File {

	@Builder.Default
	@ApiModelProperty(value = "Path for the file")
	private String path = "";

	@Builder.Default
	@ApiModelProperty(value = "File content")
	private String contents = "";

}
