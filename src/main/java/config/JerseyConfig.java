package config;

import endpoints.Endpoint;
import endpoints.ServiceEndPoints;
import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
        register(ServiceEndPoints.class);
        register(Endpoint.class);
	}

}