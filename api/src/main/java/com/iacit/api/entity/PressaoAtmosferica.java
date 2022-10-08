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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="pressao_atmosferica")
@Table(name="pressao_atmosferica")
@Getter
@Setter
@ToString
public class PressaoAtmosferica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "pra_id")
	private Integer pra_id;
	
	@Column(name= "pra_nivel_estacao")
    private BigDecimal pra_nivel_estacao;
	
	@Column(name= "pra_max")
    private BigDecimal pra_max;
	
	@Column(name= "pra_min")
    private BigDecimal pra_min;
	
	@Column(name= "pra_data_hora")
    private Timestamp dataHora;
	
	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao est_codigo;
}
