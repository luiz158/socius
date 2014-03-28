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

import br.com.socius.business.PaymentBC;
import br.com.socius.entity.Payment;

@ValidateRequest
@Path("payment")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class PaymentService {

	@Inject
	PaymentBC bc;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> findAll() throws Exception {
		return bc.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Payment findById(@PathParam("id") Long id) throws Exception {
		return bc.load(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Payment payment) throws Exception {
		bc.insert(payment);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Payment payment) throws Exception {
		bc.update(payment);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) throws Exception {
		bc.delete(id);
	}
}
