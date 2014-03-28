package br.com.socius.persistence;

import br.com.socius.entity.Payment;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class PaymentDAO extends JPACrud<Payment, Long> {
	
	private static final long serialVersionUID = 1L;
	
}
