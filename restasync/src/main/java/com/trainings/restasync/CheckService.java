package com.trainings.restasync;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import com.trainings.restasync.model.CheckList;

@Path("/checkservice")
public interface CheckService {

	@Path("/check")
	@POST
	public void check(@Suspended AsyncResponse response, CheckList checks);
}
