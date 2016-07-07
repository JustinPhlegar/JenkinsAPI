package dto;

import java.util.ArrayList;
import java.util.List;

public class Job{
	private String displayName;
	private String description;
	private String displayNameOrNull;
	private String name;
	private String url;
	private List<Jobs> jobs = new ArrayList<>();
	public Job(){}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayNameOrNull() {
		return displayNameOrNull;
	}

	public void setDisplayNameOrNull(String displayNameOrNull) {
		this.displayNameOrNull = displayNameOrNull;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Jobs> getJobs() {
		return jobs;
	}

	public void setJobs(List<Jobs> jobs) {
		this.jobs = jobs;
	}

	public static class Jobs{
		private String name;
		private String url;
		private String color;
	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
	}

}