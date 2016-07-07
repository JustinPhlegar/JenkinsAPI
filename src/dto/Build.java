package dto;

import java.util.ArrayList;
import java.util.List;

public class Build{
	private String duration;
	private String failCount;
	private String name;
	private String skipCount;
	private String total;

	public Build(){}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getFailCount() {
		return failCount;
	}

	public void setFailCount(String failCount) {
		this.failCount = failCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkipCount() {
		return skipCount;
	}

	public void setSkipCount(String skipCount) {
		this.skipCount = skipCount;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}


}