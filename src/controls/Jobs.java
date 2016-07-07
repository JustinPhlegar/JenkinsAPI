package controls;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dto.Build;
import dto.Job;
import models.BuildsModel;
import models.JobsModel;

@Path("/jenkins")
public class Jobs{
	@GET
	@Path("/jobs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJobs()  {
		JobsModel jobManager= new JobsModel();
		Job jobsData = null;
		try {
			jobsData = jobManager.getJobs();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		String messages = gson.toJson(jobsData);
		
		BuildsModel buildManager= new BuildsModel();
		Build build = null;
		JsonElement jse = new JsonParser().parse(messages);

	    JsonObject map_json = jse.getAsJsonObject();
		JsonArray jobs = map_json.getAsJsonArray("jobs");
		JsonObject blah;
		int i = 0;
		for(JsonElement job : jobs){
			blah = job.getAsJsonObject();
			//System.out.println(blah.get("name").toString());
			try {
				build = buildManager.getLastBuild(blah.get("name").toString());
				jobs.get(i).getAsJsonObject().addProperty("duration", build.getDuration());
				jobs.get(i).getAsJsonObject().addProperty("failCount", build.getFailCount());
				jobs.get(i).getAsJsonObject().addProperty("skipCount", build.getSkipCount());
				jobs.get(i).getAsJsonObject().addProperty("total", build.getTotal());
			} catch(NullPointerException npe){
			} catch (Exception e) {			
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		return Response.status(200).entity(jobs.toString()).header("Access-Control-Allow-Origin", "*").build() ;		
	}
	
	@GET
	@Path("/jobs/{job_name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJob(@PathParam("job_name") String job_name) throws Exception {
		JobsModel jobManager= new JobsModel();
		Job jobData = null;
		jobData = jobManager.getJob(job_name);
		Gson gson = new Gson();
		String messages = gson.toJson(jobData);
		
		
		return Response.status(200).entity(messages).header("Access-Control-Allow-Origin", "*").build() ;		
	}
}