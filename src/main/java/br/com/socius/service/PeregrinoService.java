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

import br.com.socius.entity.Peregrino;
import br.com.socius.persistence.PeregrinoDAO;

@Path("/api/peregrino")
public class PeregrinoService {

	@Inject
	PeregrinoDAO dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Peregrino> findAll() throws Exception {
		return dao.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Peregrino findById(@PathParam("id") Long id) throws Exception {
		return dao.load(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Peregrino peregrino) throws Exception {
		dao.insert(peregrino);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Peregrino peregrino) throws Exception {
		dao.update(peregrino);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) throws Exception {
		dao.delete(id);
	}
}
