package br.com.socius.persistence;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.socius.entity.Usuario;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> {
	
	private static final long serialVersionUID = 1L;
	
	public Usuario loadByEmail(String email) {
		String jpql = "from " + this.getBeanClass().getName() + " where email = :email";

		TypedQuery<Usuario> query = getEntityManager().createQuery(jpql, Usuario.class);
		query.setParameter("email", email);

		Usuario result;

		try {
			result = query.getSingleResult();
		} catch (NoResultException cause) {
			result = null;
		}

		return result;
	}
	
}
