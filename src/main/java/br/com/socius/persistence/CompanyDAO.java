package br.com.socius.persistence;

import br.com.socius.entity.Company;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class CompanyDAO extends JPACrud<Company, Long> {

	private static final long serialVersionUID = 1L;

}
