package ee.taltech.arete.java.response.arete;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemStateDTO {

	@ApiModelProperty(value = "JVM CPU usage")
	private Double processCpuLoad;

	@ApiModelProperty(value = "System CPU usage")
	private Double systemCpuLoad;

	@ApiModelProperty(value = "System total Disk space")
	private Long systemDiskSpaceTotal;

	@ApiModelProperty(value = "System used Disk space")
	private Long systemDiskSpaceUsed;

	@ApiModelProperty(value = "System RAM total")
	private Long systemRAMTotal;

	@ApiModelProperty(value = "System RAM usage")
	private Long systemRAMUsed;


	public SystemStateDTO() {
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
