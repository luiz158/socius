package br.com.socius.service;

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

import br.com.socius.business.EventBC;
import br.com.socius.entity.Event;
import br.com.socius.persistence.EventDAO;

@Path("/api/event")
public class EventService {

	@Inject
	EventBC bc;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> findAll() throws Exception {
		return bc.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Event findById(@PathParam("id") Long id) throws Exception {
		return bc.load(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Event event) throws Exception {
		bc.insert(event);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Event event) throws Exception {
		bc.update(event);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) throws Exception {
		bc.delete(id);
	}
}
