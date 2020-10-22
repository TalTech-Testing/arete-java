package ee.taltech.arete.java.request.hook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitDTO {

	@NotNull
	@ApiModelProperty(value = "AuthorDTO of the commit")
	private AuthorDTO author;

	@ApiModelProperty(value = "Added files")
	private Set<String> added;

	@ApiModelProperty(value = "Modified files")
	private Set<String> modified;

	@ApiModelProperty(value = "Removed files")
	private Set<String> removed;

}
