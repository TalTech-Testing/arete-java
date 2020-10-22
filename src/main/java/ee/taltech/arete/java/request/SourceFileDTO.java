package ee.taltech.arete.java.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceFileDTO {

	@NonNull
	@ApiModelProperty(value = "Contents of the file")
	private String contents;

	@NonNull
	@ApiModelProperty(value = "EX01IdCode/src/ee/taltech/iti0202/idcode/IDCodeTest.java for example")
	private String path;
}