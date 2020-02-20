package arete.java.response;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;


@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonClassDescription("Current state of the machine")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemState {

    @JsonPropertyDescription("JVM CPU usage")
    private Double processCpuLoad;

    @JsonPropertyDescription("System CPU usage")
    private Double systemCpuLoad;

    @JsonPropertyDescription("System RAM total")
    private Long systemRAMTotal;

    @JsonPropertyDescription("System RAM usage")
    private Long systemRAMUsed;

    @JsonPropertyDescription("System total Disk space")
    private Long systemDiskSpaceTotal;

    @JsonPropertyDescription("System used Disk space")
    private Long systemDiskSpaceUsed;

}
