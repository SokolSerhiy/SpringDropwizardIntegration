package ua.resource;

import com.codahale.metrics.annotation.Timed;

import ua.dao.AuthorDao;
import ua.model.AuthorModel;
import ua.spring.app.annotation.DropwizardController;

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

@DropwizardController
@Path("/author")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorResource {
	
	private final AuthorDao authorDao;
	
    public AuthorResource(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	@GET
    @Timed
    public List<AuthorModel> get(){
        return authorDao.findAll();
    }
	
	@GET
	@Timed
	@Path("/{id}")
	public AuthorModel get(@PathParam("id") int id) {
		return authorDao.findOne(id);
	}
	
	@POST
	@Timed
	public Response save(AuthorModel model) {
		authorDao.save(model);
		return Response.noContent().build();
	}
	
	@PUT
	@Timed
	@Path("/{id}")
	public Response update(@PathParam("id") int id, AuthorModel model) {
		model.setId(id);
		authorDao.update(model);
		return Response.noContent().build();
	}
	
	@DELETE
	@Timed
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		authorDao.delete(id);
		return Response.noContent().build();
	}
}
