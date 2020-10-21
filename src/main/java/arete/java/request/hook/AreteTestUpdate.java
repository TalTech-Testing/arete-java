package arete.java.request.hook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AreteTestUpdate {

	@NotNull
	@ApiModelProperty(value = "Git hook project")
	private Project project;

	@NotNull
	@ApiModelProperty(value = "Git hook project")
	private List<Commit> commits;
}
