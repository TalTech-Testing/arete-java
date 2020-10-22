package ee.taltech.arete.java.request.hook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorDTO {

	@ApiModelProperty(value = "email of the author")
	private String email;

	@NotNull
	@ApiModelProperty(value = "Name of the author")
	private String name;
}
