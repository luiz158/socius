package br.com.socius.persistence;

import br.com.socius.entity.Member;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class MemberDAO extends JPACrud<Member, Long> {
	
	private static final long serialVersionUID = 1L;
	
}
