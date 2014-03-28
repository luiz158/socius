package br.com.socius.business;

import br.com.socius.entity.Payment;
import br.com.socius.persistence.PaymentDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class PaymentBC extends DelegateCrud<Payment, Long, PaymentDAO> {

	private static final long serialVersionUID = 1L;

}
