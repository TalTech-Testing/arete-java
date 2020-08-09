package arete.java.response;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonClassDescription("Stderr or Stdout")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsoleOutput {

	@JsonPropertyDescription("Std message")
	String content;

}