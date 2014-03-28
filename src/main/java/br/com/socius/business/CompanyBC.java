package br.com.socius.business;

import br.com.socius.entity.Company;
import br.com.socius.persistence.CompanyDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class CompanyBC extends DelegateCrud<Company, Long, CompanyDAO> {

	private static final long serialVersionUID = 1L;

}
