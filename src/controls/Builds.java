package controls;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dto.Build;
import models.BuildsModel;

@Path("/jenkins")
public class Builds{
	@GET
	@Path("/lastBuild/{job_name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLastBuild(@PathParam("job_name") String job_name) throws Exception {
		BuildsModel buildManager= new BuildsModel();
		Build buildData = null;
		buildData = buildManager.getLastBuild(job_name);
		Gson gson = new Gson();
		String messages = gson.toJson(buildData);
		return Response.status(200).entity(messages).header("Access-Control-Allow-Origin", "*").build() ;	
	}
}