package br.com.socius.business;

import br.com.socius.entity.Member;
import br.com.socius.persistence.MemberDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class MemberBC extends DelegateCrud<Member, Long, MemberDAO> {

	private static final long serialVersionUID = 1L;

}
