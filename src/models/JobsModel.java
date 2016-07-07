package models;

import java.util.ArrayList;

import dao.JobDao;
import dto.Job;


public class JobsModel {
	private String jobsUrl = "https://jenkins.orasi.com/job/Selenium-Java-Core/api/json";
	private String jobUrl = "https://jenkins.orasi.com/job/Selenium-Java-Core/job/{job_name}/api/json"; 
	
	public Job getJobs() throws Exception {
		Job messages = null;
		try {
			// Here you can validate before connecting DAO class, eg. User session condition 
			JobDao jobDao= new JobDao();
			messages=jobDao.getJobs(jobsUrl);
		} 
		catch (Exception e) {
			throw e;
		}
		return messages;
	}
	

	public Job getJob(String job_name) throws Exception {
		jobUrl = jobUrl.replace("{job_name}", job_name);
		Job messages = null;
		try {
			// Here you jobDao validate before connecting DAO class, eg. User session condition 
			JobDao jobDao= new JobDao();
			messages=jobDao.getJob(jobUrl);
		} 
		catch (Exception e) {
			throw e;
		}
		return messages;
	}

}
