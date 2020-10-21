package arete.java.request;

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
public class SourceFile {

	@NotNull
	@ApiModelProperty(value = "EX01IdCode/src/ee/taltech/iti0202/idcode/IDCodeTest.java for example")
	private String path;

	@NotNull
	@ApiModelProperty(value = "Contents of the file")
	private String contents;

}