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

import br.com.socius.business.MemberBC;
import br.com.socius.entity.Member;

@ValidateRequest
@Path("member")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class MemberService {

	@Inject
	MemberBC bc;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> findAll() throws Exception {
		return bc.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Member findById(@PathParam("id") Long id) throws Exception {
		return bc.load(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Member peregrino) throws Exception {
		bc.insert(peregrino);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Member peregrino) throws Exception {
		bc.update(peregrino);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) throws Exception {
		bc.delete(id);
	}
}
