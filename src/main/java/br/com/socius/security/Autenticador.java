package br.com.socius.security;

import javax.enterprise.context.SessionScoped;

import br.com.socius.entity.Usuario;
import br.com.socius.persistence.UsuarioDAO;
import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.Credentials;
import br.gov.frameworkdemoiselle.security.InvalidCredentialsException;
import br.gov.frameworkdemoiselle.util.Beans;

@SessionScoped
public class Autenticador implements Authenticator {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	@Override
	public void authenticate() throws Exception {
		Credentials credentials = Beans.getReference(Credentials.class);
		UsuarioDAO dao = Beans.getReference(UsuarioDAO.class);
		Usuario usuario = dao.loadByEmail(credentials.getUsername());

		if (doesPasswordMatch(usuario, credentials)) {
			this.usuario = usuario;
		} else {
			throw new InvalidCredentialsException("usuário ou senha inválidos");
		}

	}

	private boolean doesPasswordMatch(Usuario usuario, Credentials credentials) {
		boolean result = false;

		if (usuario != null) {
			result = usuario.getSenha().equals(
					Passwords.hash(credentials.getPassword()));
		}

		return result;
	}

	@Override
	public void unauthenticate() throws Exception {
		this.usuario = null;
	}

	@Override
	public Usuario getUser() {
		return this.usuario;
	}

}
