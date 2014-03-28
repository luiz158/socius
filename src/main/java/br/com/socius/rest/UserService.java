package br.com.socius.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.spi.validation.ValidateRequest;

import br.com.socius.entity.User;
import br.com.socius.persistence.UserDAO;
import br.com.socius.security.Passwords;

@ValidateRequest
@Path("user")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class UserService {

	@Inject
	UserDAO dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAll() throws Exception {
		return dao.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User findById(@PathParam("id") Long id) throws Exception {
		return dao.load(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(User user) throws Exception {
		user.setPassword(Passwords.hash(user.getPassword()));
		dao.insert(user);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(User user) throws Exception {
		dao.update(user);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) throws Exception {
		dao.delete(id);
	}
}
