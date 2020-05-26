package com.qintess.ingressosonline.entity;

//import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="compra_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "evento_id", nullable = false)
	private Evento evento;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	@Column(name="qtd")
	private int qtd;
	
	@Column(name="valor_unit")
	private double valorUnit;
	
	@Column(name="valor_total")
	private double valorTotal;
	
	@Column(name="date")
	private LocalDate date;
	
	/*public void setValorTotal(double valorUnitario, Integer qtd, double valorTotal) {
			this.valorTotal = valorTotal - (valorUnitario * qtd);
		}*/
	
	@Override
	public String toString() {
		return "Compra [id=" + id + ", evento=" + evento + ", usuario=" + usuario + ", qtd=" + qtd + ", valorUnit="
				+ valorUnit + ", valorTotal=" + valorTotal + ", date=" + date + "]";
	}
}
