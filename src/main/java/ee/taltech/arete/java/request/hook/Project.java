package ee.taltech.arete.java.request.hook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

	@NotNull
	@ApiModelProperty(value = "URL or ssh for test repository.")
	private String url;

	@ApiModelProperty(value = "https://gitlab.cs.ttu.ee/iti0102-2019/ex.git > namespace = iti0102-2019")
	private String namespace;

	@ApiModelProperty(value = "https://gitlab.cs.ttu.ee/iti0102-2019/ex.git > path_with_namespace = iti0102-2019/ex")
	private String path_with_namespace;

}
