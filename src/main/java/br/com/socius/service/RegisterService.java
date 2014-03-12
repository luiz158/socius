package br.com.socius.service;

import static javax.ws.rs.core.Response.Status.CREATED;

import javax.inject.Inject;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CNPJ;
import org.jboss.resteasy.spi.validation.ValidateRequest;

import br.com.socius.entity.Entidade;
import br.com.socius.entity.Usuario;
import br.com.socius.persistence.EntidadeDAO;
import br.com.socius.persistence.UsuarioDAO;
import br.com.socius.security.Passwords;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ValidateRequest
@Path("api/register")
public class RegisterService {

	@Inject
	UsuarioDAO usuarioDAO;

	@Inject
	EntidadeDAO entidadeDAO;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(@NotNull @Valid RegisterForm registerForm) throws Exception {
		Entidade entidade = new Entidade();
		entidade.setNome(registerForm.getEntidadeNome());
		entidade.setSigla(registerForm.getEntidadeSigla());
		entidade.setCnpj(registerForm.getEntidadeCnpj());
		entidade.setSite(registerForm.getEntidadeSite());
		entidadeDAO.insert(entidade);
		
		Usuario usuario = new Usuario();
		usuario.setNome(registerForm.getUsuarioNome());
		usuario.setEmail(registerForm.getUsuarioEmail());
		usuario.setSenha(Passwords.hash(registerForm.getUsuarioSenha()));
		usuario.setEntidade(entidade);
		usuarioDAO.insert(usuario);
		
		entidade.setTitular(usuario);
		return Response.status(CREATED).build();

	}

	public static class RegisterForm {

		@NotEmpty
		private String usuarioNome;

		@NotEmpty
		private String usuarioEmail;

		@NotEmpty
		private String usuarioSenha;

		@NotEmpty
		private String entidadeNome;

		private String entidadeSigla;

		@CNPJ
		private String entidadeCnpj;

		@URL
		private String entidadeSite;

		public String getUsuarioNome() {
			return usuarioNome;
		}

		public void setUsuarioNome(String usuarioNome) {
			this.usuarioNome = usuarioNome;
		}

		public String getUsuarioEmail() {
			return usuarioEmail;
		}

		public void setUsuarioEmail(String usuarioEmail) {
			this.usuarioEmail = usuarioEmail;
		}

		public String getUsuarioSenha() {
			return usuarioSenha;
		}

		public void setUsuarioSenha(String usuarioSenha) {
			this.usuarioSenha = usuarioSenha;
		}

		public String getEntidadeNome() {
			return entidadeNome;
		}

		public void setEntidadeNome(String entidadeNome) {
			this.entidadeNome = entidadeNome;
		}

		public String getEntidadeSigla() {
			return entidadeSigla;
		}

		public void setEntidadeSigla(String entidadeSigla) {
			this.entidadeSigla = entidadeSigla;
		}

		public String getEntidadeCnpj() {
			return entidadeCnpj;
		}

		public void setEntidadeCnpj(String entidadeCnpj) {
			this.entidadeCnpj = entidadeCnpj;
		}

		public String getEntidadeSite() {
			return entidadeSite;
		}

		public void setEntidadeSite(String entidadeSite) {
			this.entidadeSite = entidadeSite;
		}

	}

}
