package endpoints;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class Endpoint {

	@GET
	public String message() {
		System.out.println("im here");
		return "Hello " ;
	}

}
