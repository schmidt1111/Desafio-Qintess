package com.qintess.ingressosonline.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
@Entity
@Table(name="casa_show")
public class CasaShow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="casa_show_id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name = "endereco")
	private String endereco;
	

	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "estado")
	private String estado;
	
	public CasaShow() {};

	public CasaShow(String nome, String endereco, String telefone, String cep, String cidade, String estado) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
	public Long getId() {
		return id;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "CasaShow [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", cep="
				+ cep + ", cidade=" + cidade + ", estado=" + estado + "]";
	}
}
