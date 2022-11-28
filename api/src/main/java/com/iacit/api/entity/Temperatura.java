package com.iacit.api.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "temperatura")
@Table(name = "temperatura")
@ToString
@Getter
@Setter
@NoArgsConstructor
@Component
public class Temperatura {
	public Temperatura(
		Estacao estCodigo, 
		Timestamp dataHora, 
		BigDecimal valor,
		BigDecimal valorMax, 
		BigDecimal valorMin
	) {
		this.estCodigo=estCodigo;
		this.dataHora=dataHora;
		this.valor=valor;
		this.valorMax=valorMax;
		this.valorMin=valorMin;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "tem_id")
    private Integer temId;

	@Column(name= "tem_ar_bulbo_seco")
	private BigDecimal valor;

	@Column(name= "tem_max")
	private BigDecimal valorMax;

	@Column(name= "tem_min")
	private BigDecimal valorMin;

	@Column(name= "tem_data_hora")
	private Timestamp dataHora;

	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao estCodigo;
}
