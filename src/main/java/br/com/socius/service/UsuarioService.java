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

import br.com.socius.entity.Usuario;
import br.com.socius.persistence.UsuarioDAO;
import br.com.socius.security.Passwords;

@Path("/api/usuario")
public class UsuarioService {

	@Inject
	UsuarioDAO dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> findAll() throws Exception {
		return dao.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario findById(@PathParam("id") Long id) throws Exception {
		return dao.load(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Usuario usuario) throws Exception {
		usuario.setSenha(Passwords.hash(usuario.getSenha()));
		dao.insert(usuario);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Usuario usuario) throws Exception {
		dao.update(usuario);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) throws Exception {
		dao.delete(id);
	}
}
