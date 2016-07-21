package models;

import java.util.ArrayList;

import dao.JobDao;
import dto.BuildByParam;
import dto.Job;


public class JobsModel {
	private String jobsUrl = "https://jenkins.orasi.com/job/Selenium-Java-Core/api/json";
	private String jobUrl = "https://jenkins.orasi.com/job/Selenium-Java-Core/job/{job_name}/api/json"; 
	private String jobUrlByParam = "https://jenkins.orasi.com/job/Selenium-Java-Core/job/{job_name}/api/json?depth=1&tree=builds[building,url,result,id,actions[failCount,skipCount,totalCount,urlName,parameters[name,value]]]";
	

	public Job getJobs(String url) throws Exception {
		Job messages = null;
		try {
			// Here you can validate before connecting DAO class, eg. User session condition 
			JobDao jobDao= new JobDao();
			messages=jobDao.getJobs(url);
		} 
		catch (Exception e) {
			throw e;
		}
		return messages;
	}
	
	
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


	public BuildByParam getJobByParam(String job_name, String param) throws Exception {
		jobUrl = jobUrlByParam.replace("{job_name}", job_name);
		System.out.println(jobUrl);
		BuildByParam messages = null;
		try {
			// Here you jobDao validate before connecting DAO class, eg. User session condition 
			JobDao jobDao= new JobDao();
			messages=jobDao.getJobByParam(jobUrl,param);
		} 
		catch (Exception e) {
			throw e;
		}
		return messages;
	}
}
