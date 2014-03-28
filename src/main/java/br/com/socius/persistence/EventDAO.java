package br.com.socius.persistence;

import br.com.socius.entity.Event;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class EventDAO extends JPACrud<Event, Long> {
	
	private static final long serialVersionUID = 1L;
	
}
