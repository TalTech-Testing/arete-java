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
public class ProjectDTO {

	@NotNull
	@ApiModelProperty(value = "URL or ssh for test repository.")
	private String url;

	@ApiModelProperty(value = "https://gitlab.cs.ttu.ee/iti0102-2019/ex.git > namespace = iti0102-2019")
	private String namespace;

	@ApiModelProperty(value = "https://gitlab.cs.ttu.ee/iti0102-2019/ex.git > path_with_namespace = iti0102-2019/ex")
	private String path_with_namespace;

}
