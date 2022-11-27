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

@Entity(name="temperatura_orvalho")
@Table(name="temperatura_orvalho")
@Getter
@Setter
@NoArgsConstructor
@Component
public class TemperaturaOrvalho {
	public TemperaturaOrvalho(
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
	@Column(name= "tdo_id")
	private Integer tdoId;

	@Column(name= "tdo_ponto")
	private BigDecimal valor;

	@Column(name= "tdo_max")
	private BigDecimal valorMax;

	@Column(name= "tdo_min")
	private BigDecimal valorMin;

	@Column(name= "tdo_data_hora")
	private Timestamp dataHora;

	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao estCodigo;
}
