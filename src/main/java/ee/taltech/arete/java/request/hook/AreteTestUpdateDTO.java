package ee.taltech.arete.java.request.hook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AreteTestUpdateDTO {

	@NotNull
	@ApiModelProperty(value = "Git hook project")
	private ProjectDTO project;

	@NotNull
	@ApiModelProperty(value = "Git hook project")
	private List<CommitDTO> commits;
}
