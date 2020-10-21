package ee.taltech.arete.java.response.arete;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonClassDescription("Stderr or Stdout")
public class ConsoleOutput {

	@Builder.Default
	@ApiModelProperty(value = "Std message")
	String content = "";

}