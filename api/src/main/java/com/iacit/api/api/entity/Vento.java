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

@Entity(name="vento")
@Table(name="vento")
@Getter
@Setter
@ToString
public class Vento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ven_id")
	private Integer ven_id;
	
	@Column(name= "ven_direcao_horaria")
	private BigDecimal ven_direcao_horaria;
    
	@Column(name= "ven_rajada_max")
	private BigDecimal ven_rajada_max;
    
	@Column(name= "ven_velocidade_horaria")
	private BigDecimal ven_velocidade_horaria;
    
	@Column(name= "ven_data_hora")
	private Timestamp ven_data_hora;
	
	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao est_codigo;
}
