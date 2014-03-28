package br.com.socius.persistence;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.socius.entity.User;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class UserDAO extends JPACrud<User, Long> {
	
	private static final long serialVersionUID = 1L;
	
	public User loadByEmail(String email) {
		String jpql = "from " + this.getBeanClass().getName() + " where email = :email";

		TypedQuery<User> query = getEntityManager().createQuery(jpql, User.class);
		query.setParameter("email", email);

		User result;

		try {
			result = query.getSingleResult();
		} catch (NoResultException cause) {
			result = null;
		}

		return result;
	}
	
}
