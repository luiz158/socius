package br.com.socius.rest;

import static javax.ws.rs.core.Response.Status.CREATED;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CNPJ;
import org.jboss.resteasy.spi.validation.ValidateRequest;

import br.com.socius.business.CompanyBC;
import br.com.socius.business.UserBC;
import br.com.socius.entity.Company;
import br.com.socius.entity.User;
import br.com.socius.security.Passwords;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ValidateRequest
@Path("register")
public class RegisterService {

	@Inject
	UserBC userBC;

	@Inject
	CompanyBC entidadeBC;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(@NotNull @Valid RegisterForm registerForm)
			throws Exception {
		Company company = new Company();
		company.setName(registerForm.getCompanyName());
		company.setAcronym(registerForm.getCompanyAcronym());
		company.setCnpj(registerForm.getCompanyCnpj());
		company.setUrl(registerForm.getCompanyUrl());
		entidadeBC.insert(company);

		User user = new User();
		user.setName(registerForm.getUserName());
		user.setEmail(registerForm.getUserEmail());
		user.setPassword(Passwords.hash(registerForm.getUserPassword()));
		user.setCompany(company);
		userBC.insert(user);

		company.setUser(user);

		return Response.status(CREATED).build();
	}

	public static class RegisterForm {

		@NotEmpty
		private String userName;

		@NotEmpty
		private String userEmail;

		@NotEmpty
		private String userPassword;

		@NotEmpty
		private String companyName;

		private String companyAcronym;

		@CNPJ
		private String companyCnpj;

		@URL
		private String companyUrl;

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}

		public String getUserPassword() {
			return userPassword;
		}

		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getCompanyAcronym() {
			return companyAcronym;
		}

		public void setCompanyAcronym(String companyAcronym) {
			this.companyAcronym = companyAcronym;
		}

		public String getCompanyCnpj() {
			return companyCnpj;
		}

		public void setCompanyCnpj(String companyCnpj) {
			this.companyCnpj = companyCnpj;
		}

		public String getCompanyUrl() {
			return companyUrl;
		}

		public void setCompanyUrl(String companyUrl) {
			this.companyUrl = companyUrl;
		}

	}

}
