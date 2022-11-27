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

@Entity(name="umidade")
@Table(name="umidade")
@Getter
@Setter
@NoArgsConstructor
@Component
public class Umidade {
	public Umidade(
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
	@Column(name= "umi_id")
	private Integer umiId;

	@Column(name= "umi_relativa_min")
	private BigDecimal valorMin;

	@Column(name= "umi_relativa_max")
	private BigDecimal valorMax;

	@Column(name= "umi_relativa_ar")
	private BigDecimal valor;

	@Column(name= "umi_data_hora")
	private Timestamp dataHora;

	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao estCodigo;
}
