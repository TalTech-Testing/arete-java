package arete.java.response.hodor_studenttester;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HodorFile {
	String path;
	String contents;
	Boolean isTest;
}
