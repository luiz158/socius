package br.com.socius.persistence;

import br.com.socius.entity.Entidade;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class EntidadeDAO extends JPACrud<Entidade, Long> {

	private static final long serialVersionUID = 1L;

}
