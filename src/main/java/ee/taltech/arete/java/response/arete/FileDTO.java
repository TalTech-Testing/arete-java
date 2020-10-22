package ee.taltech.arete.java.response.arete;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonClassDescription("FileDTO class")
public class FileDTO {

	@Builder.Default
	@ApiModelProperty(value = "Path for the file")
	private String path = "";

	@Builder.Default
	@ApiModelProperty(value = "FileDTO content")
	private String contents = "";

}
