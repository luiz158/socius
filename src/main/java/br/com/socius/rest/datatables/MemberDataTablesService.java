package br.com.socius.rest.datatables;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.spi.validation.ValidateRequest;

import br.com.socius.business.MemberBC;
import br.com.socius.entity.Member;
import br.gov.frameworkdemoiselle.pagination.Pagination;
import br.gov.frameworkdemoiselle.pagination.PaginationContext;

@ValidateRequest
@Path("member/datatables")
@Produces(APPLICATION_JSON)
public class MemberDataTablesService {

	@Inject
	private MemberBC bc;

	@Inject
	private PaginationContext paginationContext;

	@GET
	public DataTablesResult<Member> findAllPaged(@QueryParam("sEcho") Integer echo,
			@QueryParam("iDisplayStart") Integer displayStart, @QueryParam("iDisplayLength") Integer displayLength)
			throws Exception {

		Pagination pagination = paginationContext.getPagination(Member.class, true);
		pagination.setPageSize(displayLength);
		pagination.setFirstResult(displayStart);

		List<Member> data = bc.findAll();
		Long count = (long) pagination.getTotalResults();

		DataTablesResult<Member> result = new DataTablesResult<Member>();
		result.setEcho(echo);
		result.setTotalRecords(count);
		result.setTotalDisplayRecords(count);
		result.setData(data);

		return result;
	}
}
