package ua.resource;

import com.codahale.metrics.annotation.Timed;
import ua.model.TestModel;
import ua.spring.app.annotation.DropwizardController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@DropwizardController
@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    @GET
    @Timed
    public TestModel get(){
        return new TestModel("Hello");
    }
}
