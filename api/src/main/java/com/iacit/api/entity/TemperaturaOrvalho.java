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

@Entity(name="temperatura_orvalho")
@Table(name="temperatura_orvalho")
@Getter
@Setter
@ToString
public class TemperaturaOrvalho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "tdo_id")
	private Integer tdo_id;
	
	@Column(name= "tdo_ponto")
	private BigDecimal tdo_ponto;
    
	@Column(name= "tdo_max")
	private BigDecimal tdo_max;
    
	@Column(name= "tdo_min")
	private BigDecimal tdo_min;
    
	@Column(name= "tdo_data_hora")
	private Timestamp tdo_data_hora;
	
	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao est_codigo;
}
