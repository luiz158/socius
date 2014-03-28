package br.com.socius.business;

import br.com.socius.entity.Event;
import br.com.socius.persistence.EventDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class EventBC extends DelegateCrud<Event, Long, EventDAO> {

	private static final long serialVersionUID = 1L;

}
