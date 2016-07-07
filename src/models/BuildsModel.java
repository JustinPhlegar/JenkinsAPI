package models;

import dao.BuildDao;
import dto.Build;


public class BuildsModel {
	 
	

	public Build getLastBuild(String job_name) throws Exception {
		System.out.println(job_name);
		String lastBuildUrl = "https://jenkins.orasi.com/job/Selenium-Java-Core/job/"+job_name+"/lastBuild/testngreports/api/json";
		lastBuildUrl = lastBuildUrl.replace("job_name", job_name).replace("\"", "");
		System.out.println(lastBuildUrl);
		Build messages = null;
		try {
			// Here you jobDao validate before connecting DAO class, eg. User session condition 
			BuildDao jobDao= new BuildDao();
			messages=jobDao.getLastBuild(lastBuildUrl);
		} 
		catch (Exception e) {
			
		}
		return messages;
	}

}
