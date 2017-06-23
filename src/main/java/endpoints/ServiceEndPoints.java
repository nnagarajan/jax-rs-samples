package endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Employee;
import db.EmployeeDao;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import schema.EmployeeRequest;
import schema.EmployeeResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Component
@Path("/api")
public class ServiceEndPoints {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Path("/{version}/{operation}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @POST
    public Response executePost(@Context HttpHeaders httpHeaders,
                                @PathParam("version") String version,
                                @PathParam("operation") String operation,
                                String payload
    ) throws IOException {
        System.out.println("payload = " + payload);
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeRequest employeeRequest = objectMapper.readValue(payload, EmployeeRequest.class);



        Employee employeeEntity = employeeDao.findByFirstNameAndLastName(employeeRequest.getFirstName(), employeeRequest.getLastName());

        Object response = dozerBeanMapper.map(employeeEntity, EmployeeResponse.class);
        String responseString = objectMapper.writeValueAsString(response);
        System.out.println(employeeEntity);
        return Response.status(Response.Status.OK).entity(responseString).build();
    }

    @Path("/hello")
    public Response executeHello() {
        System.out.println("ServiceEndPoints.executeHello");
        return Response.status(Response.Status.OK).entity("Hello World!").build();
    }

}
