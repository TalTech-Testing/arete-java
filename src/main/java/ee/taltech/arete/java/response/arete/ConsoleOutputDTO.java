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
@JsonClassDescription("Stderr or Stdout")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsoleOutputDTO {

	@ApiModelProperty(value = "Std message")
	private String content;

}