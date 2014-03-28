package br.com.socius.business;

import br.com.socius.entity.User;
import br.com.socius.persistence.UserDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class UserBC extends DelegateCrud<User, Long, UserDAO> {

	private static final long serialVersionUID = 1L;

}
