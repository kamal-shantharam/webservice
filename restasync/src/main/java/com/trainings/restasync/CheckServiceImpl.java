package com.trainings.restasync;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.container.AsyncResponse;

import org.springframework.stereotype.Service;

import com.trainings.restasync.model.CheckList;

@Service
public class CheckServiceImpl implements CheckService {

	@Override
	public void check(AsyncResponse response, CheckList checks) {
		
		new Thread() {
			public void run() {
				
				if (checks == null || checks.getChecks() == null || checks.getChecks().size() == 0) {
					response.resume(new BadRequestException());
				}
				response.resume(true);
			}
		}.start();
		
	}

}
