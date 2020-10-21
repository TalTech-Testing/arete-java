package arete.java.response.arete;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.sun.management.OperatingSystemMXBean;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.lang.management.ManagementFactory;


@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonClassDescription("Current state of the machine")
public class SystemState {

	@Builder.Default
	@ApiModelProperty(value = "JVM CPU usage")
	private Double processCpuLoad = -1.0;

	@Builder.Default
	@ApiModelProperty(value = "System CPU usage")
	private Double systemCpuLoad = -1.0;

	@Builder.Default
	@ApiModelProperty(value = "System RAM total")
	private Long systemRAMTotal = -1L;

	@Builder.Default
	@ApiModelProperty(value = "System RAM usage")
	private Long systemRAMUsed = -1L;

	@Builder.Default
	@ApiModelProperty(value = "System total Disk space")
	private Long systemDiskSpaceTotal = -1L;

	@Builder.Default
	@ApiModelProperty(value = "System used Disk space")
	private Long systemDiskSpaceUsed = -1L;


	public SystemState() {
		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
		processCpuLoad = osBean.getProcessCpuLoad();
		systemCpuLoad = osBean.getSystemCpuLoad();
		systemRAMUsed = osBean.getFreePhysicalMemorySize();
		systemRAMTotal = osBean.getTotalPhysicalMemorySize();
		File root = new File("/");
		systemDiskSpaceTotal = root.getTotalSpace();
		systemDiskSpaceUsed = systemDiskSpaceTotal - root.getFreeSpace();
	}
}
