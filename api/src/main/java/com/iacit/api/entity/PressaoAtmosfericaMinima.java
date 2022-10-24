package com.iacit.api.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity(name="pressao_atmosferica_minima")
@Table(name="pressao_atmosferica_minima")
@Getter
@Setter
@ToString
public class PressaoAtmosfericaMinima {
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name= "pre_atm_min_id")
		private Integer preAtmMinId;
	    
	    @Column(name= "pre_atm_min_valor")
	    private BigDecimal preAtmMinValor;
	    
	    @Column(name= "pre_atm_min_data")
	    private Timestamp preAtmMinData; 
}
