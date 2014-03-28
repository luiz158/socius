package br.com.socius.security;

import javax.enterprise.context.SessionScoped;

import br.com.socius.entity.User;
import br.com.socius.persistence.UserDAO;
import br.gov.frameworkdemoiselle.security.Credentials;
import br.gov.frameworkdemoiselle.security.InvalidCredentialsException;
import br.gov.frameworkdemoiselle.util.Beans;

@SessionScoped
public class Authenticator implements br.gov.frameworkdemoiselle.security.Authenticator {

	private static final long serialVersionUID = 1L;

	private User user;

	@Override
	public void authenticate() throws Exception {
		Credentials credentials = Beans.getReference(Credentials.class);
		UserDAO dao = Beans.getReference(UserDAO.class);
		User user = dao.loadByEmail(credentials.getUsername());

		if (doesPasswordMatch(user, credentials)) {
			this.user = user;
		} else {
			throw new InvalidCredentialsException("usuário ou senha inválidos");
		}

	}

	private boolean doesPasswordMatch(User user, Credentials credentials) {
		boolean result = false;

		if (user != null) {
			result = user.getPassword().equals(
					Passwords.hash(credentials.getPassword()));
		}

		return result;
	}

	@Override
	public void unauthenticate() throws Exception {
		this.user = null;
	}

	@Override
	public User getUser() {
		return this.user;
	}

}
