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
@JsonClassDescription("FileDTO class")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileDTO {

	@ApiModelProperty(value = "FileDTO content")
	private String contents;

	@ApiModelProperty(value = "Path for the file")
	private String path;
}
