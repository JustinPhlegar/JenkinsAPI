package dto;

import java.util.ArrayList;
import java.util.List;

public class BuildByParam{
	private String building;
	private String result;
	private String url;
	private String id; 
	private List<Actions> actions = new ArrayList<Actions>();

	public BuildByParam(){}

	public List<Actions> getActions() {
		return actions;
	}

	public void setActions(List<Actions> actions) {
		this.actions = actions;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public class Actions{
		private String failCount;
		private String skipCount;
		private String totalCount;
		private String urlName;
		private List<Parameters> parameters = new ArrayList<Parameters>();
		
		public String getFailCount() {
			return failCount;
		}
		public void setFailCount(String failCount) {
			this.failCount = failCount;
		}
		public String getSkipCount() {
			return skipCount;
		}
		public void setSkipCount(String skipCount) {
			this.skipCount = skipCount;
		}
		public String getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(String totalCount) {
			this.totalCount = totalCount;
		}
		public String getUrlName() {
			return urlName;
		}
		public void setUrlName(String urlName) {
			this.urlName = urlName;
		} 
		
		public List<Parameters> getParameters() {
			return parameters;
		}
		public void setParameters(List<Parameters> parameters) {
			this.parameters = parameters;
		}

		public class Parameters{
			private String name;
			private String value;
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getValue() {
				return value;
			}
			public void setValue(String value) {
				this.value = value;
			}
			
			
		}
	}

}