package com.qintess.ingressosonline.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

//import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor   //cria automaticamente um construtor com todas os atributos da classe como argumento
//@NoArgsConstructor   //cria automaticamente um construtor vazeio (sem argumentos)
//@Data                //cria automaticamente os métodos to String, equals, hasCode, getters e setters
@Entity
@Table(name="evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="evento_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "casa_show_id", nullable = false)
	private CasaShow casaShow;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="ingresso_total")
	private Integer ingressoTotal;

	@Column (name = "data")
	private LocalDate data;
	
	//passei o metodo para o service
	/*public void setIngressoTotal(Integer qtd, Integer ingressoTotal) {
		if (qtd <= 4) {
		this.ingressoTotal = ingressoTotal - qtd;
		} else {
			System.out.println("Cada usuário pode comprar até 4 ingressos");
		} */
	}
	
