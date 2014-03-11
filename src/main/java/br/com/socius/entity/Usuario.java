package br.com.socius.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.gov.frameworkdemoiselle.security.User;

@Entity
@Table(name = "usuario")
public class Usuario implements User {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nome;

	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;

	@NotEmpty
	private String senha;

	@ManyToOne(optional=true)
	private Entidade entidade;

	@ManyToOne(optional=true)
	private Usuario titular;

	@Override
	public String getId() {
		return id == null ? null : id.toString();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public Usuario getTitular() {
		return titular;
	}

	public void setTitular(Usuario titular) {
		this.titular = titular;
	}

	@Override
	public Object getAttribute(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(Object key, Object value) {
		// TODO Auto-generated method stub

	}

}
