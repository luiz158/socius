package br.com.socius.persistence;

import br.com.socius.entity.Peregrino;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class PeregrinoDAO extends JPACrud<Peregrino, Long> {
	
	private static final long serialVersionUID = 1L;
	
}
