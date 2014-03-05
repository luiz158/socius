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

import br.com.socius.entity.Pagamento;
import br.com.socius.persistence.PagamentoDAO;

@Path("/api/pagamento")
public class PagamentoService {

	@Inject
	PagamentoDAO dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pagamento> findAll() throws Exception {
		return dao.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pagamento findById(@PathParam("id") Long id) throws Exception {
		return dao.load(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Pagamento pagamento) throws Exception {
		dao.insert(pagamento);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Pagamento pagamento) throws Exception {
		dao.update(pagamento);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) throws Exception {
		dao.delete(id);
	}
}
