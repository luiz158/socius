package br.com.socius.persistence;

import br.com.socius.entity.Pagamento;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class PagamentoDAO extends JPACrud<Pagamento, Long> {
	
	private static final long serialVersionUID = 1L;
	
}
