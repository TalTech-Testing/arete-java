package arete.java.response;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;


@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonClassDescription("File class")
public class File {

	@JsonPropertyDescription("Path for the file")
	private String path;

	@JsonPropertyDescription("File content")
	private String contents;

}
