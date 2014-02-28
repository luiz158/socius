package br.com.socius.entity;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="peregrino")
@JsonSerialize(include=Inclusion.NON_EMPTY)
public class Peregrino implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teste")
	//@SequenceGenerator(allocationSize = 1, name = "teste", sequenceName = "seq_lalala")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long numerosocio;

	@NotEmpty
	private String nome;

	@Enumerated(STRING)
	private Sangue sangue;

	@Enumerated(STRING)
	private Sexo sexo;

	private Date datanascimento;

	private String rg;

	private String cpf;

	private String email;

	private String telefoneresidencial;

	private String telefonecelular;

	private String endereco;

	private String bairro;

	private String municipio;

	private String estado;

	private String pais;

	private String cep;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumerosocio() {
		return numerosocio;
	}

	public void setNumerosocio(Long numerosocio) {
		this.numerosocio = numerosocio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sangue getSangue() {
		return sangue;
	}

	public void setSangue(Sangue sangue) {
		this.sangue = sangue;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefoneresidencial() {
		return telefoneresidencial;
	}

	public void setTelefoneResidencial(String telefoneresidencial) {
		this.telefoneresidencial = telefoneresidencial;
	}

	public String getTelefonecelular() {
		return telefonecelular;
	}

	public void setTelefonecelular(String telefonecelular) {
		this.telefonecelular = telefonecelular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
