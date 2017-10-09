package ua.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;

import io.swagger.annotations.Api;
import ua.dao.AuthorDao;
import ua.model.AuthorModel;
import ua.service.KafkaProducer;
import ua.spring.app.annotation.DropwizardController;

@DropwizardController
@Path("/author")
@Produces(MediaType.APPLICATION_JSON)
@Api("Author")
public class AuthorResource {
	
	private final AuthorDao authorDao;
	
	private final KafkaProducer kafkaProducer;
	
    public AuthorResource(AuthorDao authorDao, KafkaProducer kafkaProducer) {
		this.authorDao = authorDao;
		this.kafkaProducer = kafkaProducer;
	}

	@GET
    @Timed
    public List<AuthorModel> get(){
		kafkaProducer.send("Looking for all author");
        return authorDao.findAll();
    }
	
	@GET
	@Timed
	@Path("/{id}")
	public AuthorModel get(@PathParam("id") int id) {
		kafkaProducer.send("Looking for author id="+id);
		return authorDao.findOne(id);
	}
	
	@POST
	@Timed
	public Response save(AuthorModel model) {
		kafkaProducer.send("Saving author name="+model.getName());
		authorDao.save(model);
		return Response.noContent().build();
	}
	
	@PUT
	@Timed
	@Path("/{id}")
	public Response update(@PathParam("id") int id, AuthorModel model) {
		kafkaProducer.send("Updating author id="+id);
		model.setId(id);
		authorDao.update(model);
		return Response.noContent().build();
	}
	
	@DELETE
	@Timed
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		kafkaProducer.send("Deleting author id="+id);
		authorDao.delete(id);
		return Response.noContent().build();
	}
}
