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

@Entity(name="precipitacao")
@Table(name="precipitacao")
@Getter
@Setter
@NoArgsConstructor
@Component
public class Precipitacao {

	public Precipitacao(Estacao estCodigo, Timestamp dataHora, BigDecimal valor) {
		this.estCodigo=estCodigo;
		this.dataHora=dataHora;
		this.valor=valor;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "pre_id")
	private Integer preId;

	@Column(name= "pre_valor")

    private BigDecimal valor;

	@Column(name= "pre_data_hora")
    private Timestamp dataHora;

	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao estCodigo;
}
